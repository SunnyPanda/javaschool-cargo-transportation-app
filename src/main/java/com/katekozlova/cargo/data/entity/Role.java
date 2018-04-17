package com.katekozlova.cargo.data.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DRIVER, ROLE_USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
