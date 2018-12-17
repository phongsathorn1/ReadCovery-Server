package com.readcovery.server.controller;

import com.readcovery.server.model.Article;
import com.readcovery.server.repository.ArticleRepository;
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

    static final Map<String, Integer> categoryMap = new HashMap<String, Integer>();
    static{
        categoryMap.put("political", 1);
    }

    @GetMapping("/all")
    public List<Article> getArticle(){
        return articleRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Article> getArticleByCategory(@PathVariable(value="category") String category){
        long categoryId = -1;

        if(categoryMap.containsKey(category)) {
            categoryId = categoryMap.get(category.toLowerCase());
        }

        return articleRepository.findByCategory(categoryId);
    }
}
