package com.readcovery.server.controller;

import com.readcovery.server.model.Article;
import com.readcovery.server.model.History;
import com.readcovery.server.model.User;
import com.readcovery.server.model.UserToken;
import com.readcovery.server.repository.*;
import com.readcovery.server.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserTokenRepository userTokenRepository;

    @Autowired
    HistoryRepository historyRepository;

    static final Map<String, Integer> categoryMap = new HashMap<String, Integer>();
    static{
        categoryMap.put("political", 1);
    }

    @GetMapping("/all")
    public List<Article> getArticle(
            @RequestParam(value="token") String token ){

        List<UserToken> userTokens = userTokenRepository.findByToken(token);
        List<History> historys = historyRepository.findByUserId(userTokens.get(0).getUserId());
        List<Article> articles = articleRepository.findAll();

        List<Article> response = ArticleUtils.getArticleNotInHistory(articles, historys);
        return response;
    }

    @GetMapping("/category/{category}")
    public List<Article> getArticleByCategory(
            @PathVariable(value="category") String category,
            @RequestParam(value="token") String token ){

        long categoryId = -1;

        if(categoryMap.containsKey(category)) {
            categoryId = categoryMap.get(category.toLowerCase());
        }

        List<UserToken> userTokens = userTokenRepository.findByToken(token);
        List<History> historys = historyRepository.findByUserId(userTokens.get(0).getUserId());
        List<Article> articles = articleRepository.findByCategory(categoryId);

        List<Article> response = ArticleUtils.getArticleNotInHistory(articles, historys);

        return response;
    }

}
