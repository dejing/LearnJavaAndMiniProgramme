package com.dejing.miniprogram.config.exception;

public class CustomException extends RuntimeException {
    private int code;
    private String message;

    private CustomException(){}

    public CustomException(CustomExceptionType exceptionType, String message){
        this.code=exceptionType.getCode();
        this.message = message;
    }
    public int getCode(){
        return code;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
