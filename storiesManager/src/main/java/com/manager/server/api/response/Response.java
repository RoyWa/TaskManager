package com.manager.server.api.response;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final Object[] NO_ARGS = new Object[0];

    protected String status;
    protected String code;
    protected String message;

    public Response() {
    }

    public Response(ResponseStatus status, String code, String message) {

        this.status = status.name();
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", status)
                .add("code", code)
                .add("message", message)
                .toString();
    }
}
