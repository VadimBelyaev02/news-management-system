package com.vadim.userservice.model.enums;

public enum UserPermission {

    CREATE_NEWS("create_news"),
    DELETE_COMMENT("delete_comment"),
    CREATE_COMMENT("create_comment"),
    DELETE_NEWS("delete_news"),
    MODIFY_NEWS("modify_news");


    public String getPermission() {
        return permission;
    }

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

  }
