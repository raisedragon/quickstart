package com.raise.ums.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.raise.core.datatables.ReturnedData;
import com.raise.core.datatables.SentParameters;
import com.raise.core.mybatis.Page;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.manager.UserManager;
import com.raise.ums.query.UserQuery;



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
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list(){
		return "user/list";
	}
	
	@RequestMapping(value = "list",method=RequestMethod.POST)
	@ResponseBody
	public ReturnedData list(HttpServletRequest request){
		SentParameters parameters = new SentParameters(request);
		Page page = new Page(parameters.getStart(), parameters.getLength());
		List<UserEntity> list = userManager.list(new UserQuery(), page);
		ReturnedData data = new ReturnedData(list,page,0l);
		data.setRecordsFiltered(data.getRecordsTotal());
		return data;
	}
}
