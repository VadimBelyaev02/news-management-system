package com.vadim.newsservice.client.model.enums;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
public enum UserRole {
    ADMIN(Set.of(Permission.CREATE_COMMENT, Permission.DELETE_COMMENT, Permission.DELETE_NEWS,
            Permission.MODIFY_NEWS, Permission.CREATE_NEWS)),
    JOURNALIST(Set.of(Permission.CREATE_NEWS, Permission.CREATE_COMMENT)),
    SUBSCRIBER(Set.of(Permission.CREATE_COMMENT));

    private final Set<Permission> permissions;

    UserRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
