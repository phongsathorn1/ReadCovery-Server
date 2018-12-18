package com.readcovery.server.response;

import com.readcovery.server.model.Article;

import java.util.List;

public class ArticleListResponse {
    private List<Article> article;

    protected ArticleListResponse(){}

    public ArticleListResponse(List<Article> articles){
        this.setArticle(articles);
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
