package com.lm.sm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.lm.sm.domain.User;

public class CommandController extends AbstractCommandController {

	// ͨ�����췽��ָ����������װ���Ǹ�bean
	public CommandController() {
		this.setCommandClass(User.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse respponse, Object command,
			BindException arg3) throws Exception {
		// ֵ����װ��user����
		User user = (User) command;
		// ��ȡModelAndView����
		ModelAndView mv = new ModelAndView();
		// ���۲���
		mv.addObject("user", user);
		// �����߼���ͼ
		mv.setViewName("index");
		return mv;
	}

	// ʱ������ת��
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// ��ȡҳ������
		String str = request.getParameter("birthday");
		// �ж��Ƿ����/
		if (str.contains("-")) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		} else {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		}
		super.initBinder(request, binder);
	}

}
