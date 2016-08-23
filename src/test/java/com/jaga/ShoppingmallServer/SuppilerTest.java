package com.jaga.ShoppingmallServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaga.shoppingmall.dao.SuppilerDAO;
import com.jaga.shoppingmall.model.Suppiler;

public class SuppilerTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.jaga");
		context.refresh();
	
	SuppilerDAO suppilerDAO =   (SuppilerDAO) context.getBean("suppilerDAO");
	Suppiler suppiler=(Suppiler)context.getBean("suppiler");
	

	suppiler.setId("SUP001");
	suppiler.setName("SUPName001");
    suppiler.setAddress("chennai");
	if (suppilerDAO.save(suppiler) == true)
		
	{
	System.out.println("Suppiler created successfully");

	}
	else
	{
		System.out.println("not able to create suppiler");
		
	}
	}}
