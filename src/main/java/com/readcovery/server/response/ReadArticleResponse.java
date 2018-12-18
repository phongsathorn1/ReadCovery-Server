package com.readcovery.server.response;

import com.readcovery.server.model.Article;

public class ReadArticleResponse {
    private Article article;
    private boolean success;

    protected ReadArticleResponse(){}

    public ReadArticleResponse(Article article, boolean success){
        this.setArticle(article);
        this.setSuccess(success);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
