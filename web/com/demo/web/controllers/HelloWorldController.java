package com.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 定义一个Controller
 * @author admin
 *
 */
@Controller	// 将HelloWorldController指定为Controller
@RequestMapping(value = "/helloworld")	// 指定该Controller映射的请求
public class HelloWorldController {
	// 指定ModelAndView为一个Action，value值指定该Action映射的请求，只接受GET请求；
	@RequestMapping(value="/index", method={RequestMethod.GET})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello World!");
		modelAndView.setViewName("index");	// 指定该Action对应的视图名称
		return modelAndView;
	}
}
