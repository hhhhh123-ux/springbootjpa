package com.springboothibernate.demo.expection;


public class BaseException extends RuntimeException{
private int code;
    private BaseException(String message){
        super(message);
    }

private BaseException(int code,String message){
    super(message);
    this.code=code;
}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
