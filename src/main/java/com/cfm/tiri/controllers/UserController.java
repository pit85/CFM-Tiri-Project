package com.cfm.tiri.controllers;

import com.cfm.tiri.jpa.Role;
import com.cfm.tiri.jpa.User;
import com.cfm.tiri.services.RoleService;
import com.cfm.tiri.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.listAllUsers());
        System.out.println("Returning users:");
        return "users";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "userform";
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "userform";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user){

    	userService.saveUser(user);

        return "redirect:/user/" + user.getId();
    }
    
    @RequestMapping(value = "users/active/{active}", method = RequestMethod.GET)
    public String listActive(@PathVariable Boolean active, Model model){
        System.out.println("Test active users:");
        model.addAttribute("users", userService.listActiveUsers(active));
        return "users";
    }
    
    
    
    @ModelAttribute("allRoles")
    public List<Role> listAllRoles() {
        return (List<Role>) this.roleService.listAllRoles();
    }

}
