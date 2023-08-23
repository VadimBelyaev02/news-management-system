package com.vadim.userservice.model.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Permission;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN(Set.of(UserPermission.CREATE_COMMENT, UserPermission.DELETE_COMMENT, UserPermission.DELETE_NEWS,
            UserPermission.MODIFY_NEWS, UserPermission.CREATE_NEWS)),
    JOURNALIST(Set.of(UserPermission.CREATE_NEWS, UserPermission.CREATE_COMMENT)),
    SUBSCRIBER(Set.of(UserPermission.CREATE_COMMENT));
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;

    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}