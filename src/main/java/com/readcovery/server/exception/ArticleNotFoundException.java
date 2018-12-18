package com.readcovery.server.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(long id){
        super("Article id "+id+" not found");
    }
}
