package com.onlineshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.dao.CategoryDAO;
import com.onlineshopping.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;	
	
	@BeforeClass
	
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlineshopping");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("Televison");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Sucessfully added a category inside the table!",true,categoryDAO.add(category));
		
	}
	
}
