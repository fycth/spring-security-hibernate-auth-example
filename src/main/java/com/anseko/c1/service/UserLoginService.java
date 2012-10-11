package com.anseko.c1.service;

import com.anseko.c1.domain.Person;
import com.anseko.c1.security.CustomUser;
import com.anseko.c1.security.UserGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 11:37 AM
 */
public class UserLoginService implements UserDetailsService
{
    @Resource(name="personService")
    private PersonService personService;

    private Map<String,String> roles = new HashMap<String,String>();

    public UserLoginService()
    {
        roles.put("ROLE_USER","Customer");
        roles.put("ROLE_ADMIN","Admin");
    }

    public Map<String,String> getRoles()
    {
        return roles;
    }

    public UserDetails loadUserByUsername(String username)
    {
        if (username != null && !username.equals(""))
        {
            Person person = personService.get(username);
            if (person == null) {
                return null;
            }
            GrantedAuthority grantedAuth = new UserGrantedAuthority(person.getRole());
            return new CustomUser(person.getId(), person.getLogin(), person.getPasswd(), new GrantedAuthority[]{ grantedAuth });
        } else {
            return null;
        }
    }
}
