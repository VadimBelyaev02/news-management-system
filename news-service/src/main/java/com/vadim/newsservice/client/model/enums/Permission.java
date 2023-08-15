package com.vadim.newsservice.client.model.enums;

import java.util.Set;

public enum Permission {

    CREATE_NEWS("create_news"),
    DELETE_COMMENT("delete_comment"),
    CREATE_COMMENT("create_comment"),
    DELETE_NEWS("delete_news"),
    MODIFY_NEWS("modify_news");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
