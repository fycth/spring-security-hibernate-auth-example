package com.anseko.c1.controller;

import com.anseko.c1.domain.Person;
import com.anseko.c1.service.PersonService;
import com.anseko.c1.service.UserLoginService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 11:46 AM
 */

@Controller
@RequestMapping(value="/", method = RequestMethod.GET)
public class MainController
{
    protected static Logger logger = Logger.getLogger(MainController.class);

    @Resource(name="personService")
    private PersonService personService;

    @Resource(name="userLoginService")
    private UserLoginService userLoginService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal )
    {
        Person person = personService.get(principal.getName());
        model.addAttribute("person", person);

        if (person.getRole().equals("ROLE_ADMIN")) return "admin";

        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model)
    {
        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model)
    {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model)
    {
        return "login";
    }

    @RequestMapping(value="/accessDenied", method = RequestMethod.GET)
    public String accessDenied(ModelMap model)
    {
        return "error_403";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(ModelMap model)
    {
        model.addAttribute("personAttribute", new Person());
        model.addAttribute("roles",userLoginService.getRoles());
        return "register";
    }

    @RequestMapping(value = "/register_new", method = RequestMethod.POST)
    public String Add(@ModelAttribute("personAttribute") Person person)
    {
        personService.add(person);
        return "redirect:/";
    }
}
