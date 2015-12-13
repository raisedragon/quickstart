package com.raise.web.ums.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raise.core.datatables.ReturnedData;
import com.raise.core.datatables.SentParameters;
import com.raise.core.mybatis.Page;
import com.raise.core.web.MessageHelper;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserQuery;
import com.raise.web.security.UserDetailsServiceImpl;
import com.raise.web.ums.xservice.UserXService;


@Controller
@RequestMapping("/user")
public class UserController {
	private static interface VIEW_NAME{
	    	static String SIGNUP= "user/signup";
    }
    
    private static interface MESSAGE{
    	static String SIGNUP_SUCCESS = "signup.success";
    }
	    
	@Autowired
	private UserXService userXService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@RequestMapping("list")
	public String listView(HttpServletRequest request, HttpServletResponse response){
		return "user/list";
	}
	
	
	@RequestMapping(value="getDatas",method = RequestMethod.POST)
	@ResponseBody
	public ReturnedData getDatas(HttpServletRequest request, HttpServletResponse response){
		SentParameters parameters = new SentParameters(request);
		Page page = new Page(parameters.getStart(), parameters.getLength());
		UserQuery query = new UserQuery();
		query.setPage(page);;
		List<UserEntity> list = userXService.list(query);
		ReturnedData data = new ReturnedData(list,page,0l);
		data.setRecordsFiltered(data.getRecordsTotal());
		return data;
	}
	
	
	@RequestMapping("signup")
	public String signup(Model model){
		model.addAttribute(new UserEntity());
		return "user/signup";
	}
	
	
	@RequestMapping(value = "signup",method = RequestMethod.POST)
	public String signup(@ModelAttribute UserEntity user, Errors errors, RedirectAttributes ra){
		if (errors.hasErrors()) {
			return VIEW_NAME.SIGNUP;
		}
		userXService.add(user);
		userDetailsService.signin(user);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, MESSAGE.SIGNUP_SUCCESS);
		return "redirect:/";
	}
	
}
