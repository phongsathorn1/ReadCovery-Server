package com.readcovery.server.exception;

public class UserTokenInvalidException extends RuntimeException{
    public UserTokenInvalidException(){
        super("User token is invalid");
    }
}
