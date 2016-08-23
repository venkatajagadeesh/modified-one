package com.jaga.ShoppingmallServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.shoppingmall.dao.ProductDAO;
import com.jaga.shoppingmall.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.jaga");
		context.refresh();
		
		ProductDAO productDAO= (ProductDAO) context.getBean("productDAO");
		Product product =(Product) context.getBean("product");
	product.setId("CG003");
	product.setName("mobile");
	product.setDescription("this is mobile product");
	
	if(	productDAO.save(product)==true)
	{
		System.out.println("product created successfully");
	}
	else{
		System.out.println("not able to create product");
	}

	}
}
