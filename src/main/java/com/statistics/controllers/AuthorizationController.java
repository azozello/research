package com.statistics.controllers;

import com.statistics.models.classes.ROLE;
import com.statistics.models.enteties.User;
import com.statistics.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AuthorizationController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "pages/login.html";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String newUserForm(){
        return "pages/userform.html";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newUserCreate(@RequestParam String username,
                                @RequestParam String password1,
                                @RequestParam String password2){
        if (!password1.equals(password2)) return "redirect:/newuser";
        else {
            try {
                ArrayList<String> emails = new ArrayList<>();
                Iterable<User> users = userService.getAllUsers();
                for (User user : users){
                    emails.add(user.getEmail());
                }
                if (!emails.contains(username)) {
                    userService.insertUser(new User(username, password1, ROLE.USER));
                } else return "redirect:/newuser";
            } catch (Exception e){
                e.printStackTrace();
            }
            return "redirect:/login";
        }
    }
}
