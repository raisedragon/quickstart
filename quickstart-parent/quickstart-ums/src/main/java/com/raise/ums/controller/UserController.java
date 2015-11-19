package com.raise.ums.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.raise.ums.entity.UserEntity;
import com.raise.ums.manager.UserManager;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserManager userManager;
	
	
	@RequestMapping(value = "current", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public UserEntity accounts(Principal principal) {
        Assert.notNull(principal);
        return userManager.findByAccount(principal.getName());
    }
}
