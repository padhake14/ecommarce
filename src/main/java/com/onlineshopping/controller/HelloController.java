package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshopping.dao.CategoryDAO;
import com.onlineshopping.dto.Category;

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
	
	/*
	 * method to load all products based on catgeory
	 */
	@RequestMapping(value = "show/all/products")

	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing the list of catgeory
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "show/category/{id}/products")

	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//Category dao to fetch a single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of category
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single ctagoey object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
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
