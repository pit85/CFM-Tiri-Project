package com.cfm.tiri.controllers;

import com.cfm.tiri.domain.Role;
import com.cfm.tiri.domain.User;
import com.cfm.tiri.services.RoleService;
import com.cfm.tiri.services.UserService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showUser(@PathVariable long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "userform";
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "userform";
    }

    //Validation of form
    @RequestMapping(value="user", method=RequestMethod.GET)
    public String backToForm() {
        return "userform";
    }

    @RequestMapping(value="user", method=RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            //form is not filled properly
            return "userform";
        } else {
            //form is filled properly
        	userService.saveUser(user);
            return "redirect:/user/" + user.getId();
        }
    }
    
	@RequestMapping(value = "users/search", method = RequestMethod.GET)
	public String listActive(
			@RequestParam(defaultValue="0", value = "option", required = false) int option,
			Model model) {
		
		switch (option){
		case 1:
			model.addAttribute("users", userService.listActiveUsers(true));
			break;
		case 2:
			model.addAttribute("users", userService.listActiveUsers(false));
			break;
		case 0:
			model.addAttribute("users", userService.listAllUsers());
			break;
		}
		
		return "users";
	}
    
    @ModelAttribute("allRoles")
    public List<Role> listAllRoles() {
        return (List<Role>) this.roleService.listAllRoles();
    }

}
