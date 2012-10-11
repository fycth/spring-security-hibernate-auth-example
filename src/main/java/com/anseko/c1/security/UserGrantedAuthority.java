package com.anseko.c1.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 10:56 AM
 */
public class UserGrantedAuthority implements GrantedAuthority
{
    private static final long serialVersionUID = -3786297951121082644L;

    private String authority = null;
    public UserGrantedAuthority(String auth) { authority = auth; }

    @Override
    public String getAuthority() { return authority; }
}
