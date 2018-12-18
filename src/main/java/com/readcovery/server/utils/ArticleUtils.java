package com.readcovery.server.utils;

import com.readcovery.server.model.Article;
import com.readcovery.server.model.History;

import java.util.ArrayList;
import java.util.List;

public class ArticleUtils {
    public static List<Article> getArticleNotInHistory(
            List<Article> articles,
            List<History> historys){

        List<Article> response = new ArrayList<>();

        for (Article article : articles){
            boolean haveInHistory = false;
            for (History history : historys){
                if (article.getId() == history.getArticleId()){
                    haveInHistory = true;
                    break;
                }
            }
            if(!haveInHistory){
                response.add(article);
            }
        }

        return response;
    }
}
