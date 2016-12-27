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

	// 通过构造方法指定将参数封装到那个bean
	public CommandController() {
		this.setCommandClass(User.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse respponse, Object command,
			BindException arg3) throws Exception {
		// 值被封装到user对象
		User user = (User) command;
		// 获取ModelAndView对象
		ModelAndView mv = new ModelAndView();
		// 调价参数
		mv.addObject("user", user);
		// 设置逻辑视图
		mv.setViewName("index");
		return mv;
	}

	// 时间类型转换
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// 获取页面数据
		String str = request.getParameter("birthday");
		// 判断是否包含/
		if (str.contains("-")) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		} else {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		}
		super.initBinder(request, binder);
	}

}
