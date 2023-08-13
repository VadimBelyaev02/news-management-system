package com.vadim.newsservice.client.model.enums;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
public enum UserRole {
    ADMIN(Set.of(Permission.READ, Permission.WRITE, Permission.UPDATE, Permission.DELETE, Permission.CRUD_ANY)),
    JOURNALIST(Set.of(Permission.CRUD_OWN)),
    SUBSCRIBER(Set.of(Permission.CRUD_OWN));

    private final Set<Permission> permissions;

    UserRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
