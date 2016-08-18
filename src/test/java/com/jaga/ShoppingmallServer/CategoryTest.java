package com.jaga.ShoppingmallServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.shoppingmall.dao.CategoryDAO;
import com.jaga.shoppingmall.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jaga");
		context.refresh();
		
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		Category category =(Category) context.getBean("category");
	category.setId("CG001");
	category.setName("mobile");
	category.setDescription("this is mobile category");
	
	if(	categoryDAO.save(category)==true)
	{
		System.out.println("category created successfully");
	}
	else{
		System.out.println("not able to create category");
	}

	}
}
