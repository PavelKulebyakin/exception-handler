package com.spring.practice.exceptionhandler.exception;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }

}
