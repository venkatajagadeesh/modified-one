package com.jaga.ShoppingmallServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.shoppingmall.dao.CategoryDAO;
import com.jaga.shoppingmall.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;
@Autowired
	Category category;
AnnotationConfigApplicationContext context;

@Before
public void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.jaga");
	context.refresh();
	categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	category = (Category) context.getBean("category");
}
@Test
public void categoryListTestCase(){
	List<Category> list=categoryDAO.list();
	int rowCount =list.size();
assertEquals("Category list test case",rowCount, 6);	
}

@Test
public void categoryGetTestCase(){
	category=categoryDAO.get("CG001");
	assertEquals(category.getName(), "mobile");
}
}
