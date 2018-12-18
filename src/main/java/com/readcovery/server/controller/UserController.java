package com.readcovery.server.controller;

import com.readcovery.server.exception.ArticleNotFoundException;
import com.readcovery.server.exception.ResourceNotFoundException;
import com.readcovery.server.exception.UserAuthenticationException;
import com.readcovery.server.exception.UserTokenInvalidException;
import com.readcovery.server.model.Article;
import com.readcovery.server.model.History;
import com.readcovery.server.model.User;
import com.readcovery.server.model.UserToken;
import com.readcovery.server.repository.ArticleRepository;
import com.readcovery.server.repository.HistoryRepository;
import com.readcovery.server.repository.UserRepository;
import com.readcovery.server.repository.UserTokenRepository;
import com.readcovery.server.response.ReadArticleResponse;
import com.readcovery.server.utils.PasswordUtils;
import com.readcovery.server.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTokenRepository userTokenRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("{id}")
    public User getUserById(@PathVariable(value="id") Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User createUser(@RequestParam Map<String, String> user){
        String name = user.get("name");
        String password = user.get("password");
        String email = user.get("email");
        String interestedCategory = user.get("interested_category");

        User newUser = new User(name, password, email, interestedCategory);
        return userRepository.save(newUser);
    }

    @PostMapping(path = "/auth", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public UserToken auth(@RequestParam Map<String, String> user){
        String email = user.get("email");
        String password = user.get("password");

        List<User> results = userRepository.findByEmail(email);
        if(results.size() == 0){
            throw new UserAuthenticationException();
        }

        User userdata = results.get(0);
        if(!PasswordUtils.match(password, userdata.getPassword())){
            throw new UserAuthenticationException();
        }

        RandomString genToken = new RandomString();

        UserToken newToken = new UserToken();
        newToken.setToken(genToken.nextString());
        newToken.setUserId(results.get(0).getId());

        return userTokenRepository.save(newToken);
    }

    @GetMapping(path = "/read/{id}")
    public ReadArticleResponse readedArticle(
            @PathVariable long id,
            @RequestParam Map<String, String> article){

        long articleId = id;
        if(!articleRepository.existsById(articleId)){
            throw new ArticleNotFoundException(articleId);
        }

        List<UserToken> userToken = userTokenRepository.findByToken(article.get("token"));

        Article articleData = articleRepository.findById(articleId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        History history = new History(articleId, userToken.get(0).getUserId());
        historyRepository.save(history);

        ReadArticleResponse response = new ReadArticleResponse(articleData, true);

        return response;
    }
}
