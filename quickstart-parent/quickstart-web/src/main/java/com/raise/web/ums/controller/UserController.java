package com.raise.web.ums.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raise.core.datatables.ReturnedData;
import com.raise.core.datatables.SentParameters;
import com.raise.core.mybatis.Page;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserQuery;
import com.raise.web.ums.xservice.UserXService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserXService userXService;
	
	@RequestMapping("listView")
	public String listView(HttpServletRequest request, HttpServletResponse response){
		return "list";
	}
	
	
	@RequestMapping("list")
	@ResponseBody
	public ReturnedData list(HttpServletRequest request, HttpServletResponse response){
		SentParameters parameters = new SentParameters(request);
		Page page = new Page(parameters.getStart(), parameters.getLength());
		UserQuery query = new UserQuery();
		query.setPage(page);;
		List<UserEntity> list = userXService.list(query);
		ReturnedData data = new ReturnedData(list,page,0l);
		data.setRecordsFiltered(data.getRecordsTotal());
		return data;
	}
	
	
}
