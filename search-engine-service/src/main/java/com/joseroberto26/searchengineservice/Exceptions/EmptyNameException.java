package com.joseroberto26.searchengineservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyNameException extends RuntimeException{

    public EmptyNameException(String message){
        super(message);
    }

    public EmptyNameException(String message, Throwable cause){
        super(message, cause);
    }
}
