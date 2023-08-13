package com.vadim.newsservice.client.model.enums;

public enum Permission {

    CRUD_NEWS("crud_news"),
    CRUD_COMMENTS("crud_comments"),
    DELETE("delete"),
    UPDATE("update"),
    READ("read"),
    WRITE("write");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
