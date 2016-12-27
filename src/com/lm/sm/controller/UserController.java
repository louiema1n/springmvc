package com.lm.sm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//����ModelAndView����
		ModelAndView mv = new ModelAndView();
		//�������
		mv.addObject("hello", "���ϲ����");
		//����������ͼ
		//mv.setViewName("/index.jsp");
		//�����߼���ͼ
		mv.setViewName("index");
		return mv;
	}
	
}
