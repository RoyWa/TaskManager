package com.manager.server.api.response;

import com.google.common.base.MoreObjects;

public class EntityResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("super", super.toString())
                .add("entity", entity)
                .toString();
    }
}
