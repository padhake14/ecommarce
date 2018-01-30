package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshopping.dao.CategoryDAO;

@Controller
public class HelloController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = { "/", "/home", "/index" })

	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = { "/about" })

	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })

	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}

//	@RequestMapping(value = { "/test" })
//	public ModelAndView test(@RequestParam(value = "title",required=false) String title) {
//		if(title == null) {
//			title = "Hello There";
//		 }
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("title",title);
//		return mv;
//	}
	
//	 @RequestMapping(value = {"/test/{title}"})
//		 public ModelAndView test(@PathVariable("title")String title) {
//		 if(title == null) {
//			 title = "Hello There";
//		 }
//		
//		 ModelAndView mv = new ModelAndView("page");
//		 mv.addObject("title", title);
//		 return mv;
//		 }
		
}
