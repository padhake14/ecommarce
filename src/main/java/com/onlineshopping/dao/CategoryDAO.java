package com.onlineshopping.dao;

import java.util.List;

import com.onlineshopping.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	List<Category> list();

	Category get(int id);
}
