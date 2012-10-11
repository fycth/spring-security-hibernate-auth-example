package com.anseko.c1.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 11:41 AM
 */

@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWD")
    private String passwd;

    @Column(name = "ROLE")
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
