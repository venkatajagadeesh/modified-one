package com.jaga.ShoppingmallServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaga.shoppingmall.dao.UserDetailsDAO;
import com.jaga.shoppingmall.model.UserDetails;

public class UserDetailsTest {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.jaga");
		context.refresh();
	
	UserDetailsDAO userDetailsDAO =   (UserDetailsDAO) context.getBean("userDetailsDAO");
	UserDetails userDetails=(UserDetails)context.getBean("userDetails");
	

	userDetails.setId("CG001");
	userDetails.setName("CGName001");
	userDetails.setPassword("gkuar");
	userDetails.setMail("fagsr");
	userDetails.setContact("gfgsdf");
	userDetails.setAdders("bsfhsd");
	if (userDetailsDAO.save(userDetails) == true)
		
	{
	System.out.println("UserDetails created successfully");

	}
	else
	{
		System.out.println("not able to create userdetails");
	}
	}}