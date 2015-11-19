package com.raise.ums.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raise.core.web.MessageHelper;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.form.SignupForm;
import com.raise.ums.manager.UserManager;
import com.raise.ums.security.UserDetailsServiceImpl;


@Controller
public class SignupController {

    
    private static interface VIEW_NAME{
    	static String SIGNUP= "signup/signup";
    }
    
    private static interface MESSAGE{
    	static String SIGNUP_SUCCESS = "signup.success";
    }

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
        return VIEW_NAME.SIGNUP;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return VIEW_NAME.SIGNUP;
		}
		UserEntity user = signupForm.createUser();
		userManager.add(signupForm.createUser());
		userDetailsServiceImpl.signin(user);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, MESSAGE.SIGNUP_SUCCESS);
		return "redirect:/";
	}
}
