package com.jm.jimnisbakery.global.common;

import lombok.Getter;

@Getter
public class ApiResult<T> {
    private int status;
    private String statusKey;
    private T data;

    public ApiResult(int status){
        this.status = status;
        this.statusKey = StatusType.getStatusKey(status);
        this.data = null;
    }

    public static ApiResult Succeed(){
        return new ApiResult(StatusType.SUCCESS);
    }

    public static ApiResult Failed(int status){
        return new ApiResult(status);
    }

    public ApiResult(int status, T data){
        this.status = status;
        this.statusKey = StatusType.getStatusKey(status);
        this.data = data;
    }
    public static <T> ApiResult<T> Succeed(T data){
        return new ApiResult(StatusType.SUCCESS, data);
    }

    public static <T> ApiResult<T> Failed(int status, T data){
        return new ApiResult(status, data);
    }
}
