package tk.leaflame.websocketdemo.common;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

public class Result<T> {

    private int status;
    private String message;
    private T data;
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAILED_MESSAGE = "FAILED";
    private static final String DEFAULT_NOT_FOUND_MESSAGE = "NOT FOUND";
    private static final String DEFAULT_UNAUTHORIZED_MESSAGE = "UNAUTHORIZED";
    private static final String DEFAULT_INTERNAL_SERVER_ERROR_MESSAGE = "INTERNAL SERVER ERROR";

//    private Result{
//    }

//    private Result(int status, String message, T data) {
//        this.status = status;
//        this.message = message;
//        this.data = data;
//    }

    private Result setCode(ResultCode resultCode) {
        this.status = resultCode.code();
        return this;
    }

    public int getCode() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static Result ok(String message, Object data) {
        return new Result().setCode(ResultCode.SUCCESS).setMessage(message != null ? message : DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static Result ok() {
        return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result error() {
        return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(DEFAULT_INTERNAL_SERVER_ERROR_MESSAGE);
    }

    public static Result unauthorized() {
        return new Result().setCode(ResultCode.UNAUTHORIZED).setMessage(DEFAULT_UNAUTHORIZED_MESSAGE);
    }

    public static Result failed() {
        return new Result().setCode(ResultCode.FAILED).setMessage(DEFAULT_FAILED_MESSAGE);
    }
    //todo
}
