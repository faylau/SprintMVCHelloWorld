package com.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	/**
	 * 指定ModelAndView为一个Action，value值指定该Action映射的请求，只接受GET请求；
	 * @return
	 */
	@RequestMapping(value="/index", method={RequestMethod.GET})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello World!");
		modelAndView.setViewName("index");	// 指定该Action对应的视图名称
		return modelAndView;
	}
	
	/**
	 * URL请求参数映射
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detail/{id}", method={RequestMethod.GET})
	public ModelAndView getDetail(@PathVariable(value="id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("detail");
		return modelAndView;
	}
	
	/**
	 * 通过正则表达式配置映射规则
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}", method={RequestMethod.GET})
	public ModelAndView regUrlTest(@PathVariable(value="name") String name, @PathVariable(value="age") Integer age) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.addObject("age", age);
		modelAndView.setViewName("regurltest");
		return modelAndView;
	}
}
