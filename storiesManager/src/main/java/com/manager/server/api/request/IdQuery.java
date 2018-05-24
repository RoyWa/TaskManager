package com.manager.server.api.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

public class IdQuery {

    @NotNull
    @Min(1)
    private Integer id;

    public IdQuery() {
    }

    public IdQuery(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
