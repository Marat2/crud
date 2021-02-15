package com.controller;

import com.domain.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private  Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getIndex(ModelMap model){
        List<User> users = userService.listUsers();
        logger.info("Number of users : "+users.toString());
        model.addAttribute("users",users);
        return "index";
    }
    @RequestMapping("/add")
    public String addUser(){
        return "add";
    }
    @PostMapping(path = "/save",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveUser(User user){
        System.out.println("eteetet" +user.toString());
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam Long id,ModelMap model){
        User user = userService.userById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @PostMapping(path = "/update",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateUser(User user){
        System.out.println("eteetet" +user.toString());
        userService.update(user.getId(),user);
        return "redirect:/";
    }
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam Long id){
        userService.delete(id);
        return "redirect:/";
    }
}
