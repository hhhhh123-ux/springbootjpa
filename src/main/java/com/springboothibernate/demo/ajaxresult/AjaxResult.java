package com.springboothibernate.demo.ajaxresult;

import lombok.Data;
import org.springframework.util.unit.DataSize;

import java.io.Serializable;

@Data
public class AjaxResult<T> implements Serializable {
    private static final int code_SUCCESS = 1;
    private static final int code_FAILED = 0;
    private int code;
    private String message;
    private T data;
    private String debug;

    public  AjaxResult(int code,String message,T data,String debug){
        this.code=code;
        this.message=message;
        this.data=data;
        this.debug=debug;
    }

    public static AjaxResult failed(String message) {
        return new AjaxResult(code_FAILED,message,null,null);
    }
    public static AjaxResult failed(int code,String message) {
        return new AjaxResult(code_FAILED,message,null,null);
    }
    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<T>(code_SUCCESS,null,data,null);
    }

    public static AjaxResult failed(String message,String debug) {
        return new AjaxResult(code_FAILED,message,null,debug);
    }

}
