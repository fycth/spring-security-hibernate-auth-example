package com.anseko.c1.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 10:47 AM
 */
public class CustomUser implements Serializable, UserDetails
{
    private static final long serialVersionUID = 1201392234549297485L;
    private long id;
    private String password;
    private String username;
    private GrantedAuthority[] authorities = null;

    public CustomUser(int id, String username, String password, GrantedAuthority[] authorities)
    {
        this.id = id;
        this.password = password;
        this.username = username;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        Collections.addAll(auth, authorities);
        return auth;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
