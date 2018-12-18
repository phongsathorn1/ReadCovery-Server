package com.readcovery.server.exception;

public class UserAuthenticationException extends RuntimeException {
    public UserAuthenticationException(){
        super("Email or Password doesn't match!");
    }
}
