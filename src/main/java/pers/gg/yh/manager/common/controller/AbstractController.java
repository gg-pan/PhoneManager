package pers.gg.yh.manager.common.controller;

import pers.gg.yh.manager.common.response.Result;

public abstract class AbstractController {
    private static final int SUCCESSFUL_CODE = 200;
    private static final String SUCCESSFUL_MESSAGE = "OK";

    protected Result<Void> successResponse() {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESSAGE);
    }

    protected <T> Result<T> successResponse(T data) {
        return new Result<T>(SUCCESSFUL_CODE, SUCCESSFUL_MESSAGE, data);
    }

    protected <T> Result<T> successResponse(String message, T data) {
        return new Result<T>(SUCCESSFUL_CODE, message, data);
    }
}
