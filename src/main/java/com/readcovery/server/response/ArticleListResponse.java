package com.readcovery.server.response;

import com.readcovery.server.model.Article;

import java.util.List;

public class ArticleListResponse {
    private List<Article> articles;

    protected ArticleListResponse(){}

    public ArticleListResponse(List<Article> articles){
        this.setArticle(articles);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticle(List<Article> articles) {
        this.articles = articles;
    }
}
