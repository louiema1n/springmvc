package com.lm.sm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//创建ModelAndView对象
		ModelAndView mv = new ModelAndView();
		//添加属性
		mv.addObject("hello", "凤姐喜欢你");
		//设置物理视图
		//mv.setViewName("/index.jsp");
		//设置逻辑视图
		mv.setViewName("index");
		return mv;
	}
	
}
