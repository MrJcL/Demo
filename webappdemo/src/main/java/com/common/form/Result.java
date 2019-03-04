package com.common.form;

/**
 * @program: Demo
 * @Date: 2019/3/4 21:54
 * @Author: LiJc
 * @Description:
 */
public class Result {
    private String message;
    private boolean isSuccess = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
