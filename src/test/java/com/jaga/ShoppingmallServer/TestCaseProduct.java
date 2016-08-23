package com.jaga.ShoppingmallServer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.shoppingmall.dao.ProductDAO;
import com.jaga.shoppingmall.model.Product;

public class TestCaseProduct {

@Autowired
ProductDAO productDAO;
@Autowired
Product product;

AnnotationConfigApplicationContext context;
@Before
public void init()
{
	context= new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	productDAO = (ProductDAO) context.getBean("ProductDAO");
	product = (Product) context.getBean("product");	
 }
@Test
public void deleteproductTestCase()
{
	product.setId("PRD_001");
	boolean flag = productDAO.delete(product);
	assertEquals("deleteProductTestCase", flag,false);
}
@Test
public void addProductTestCase()
{
	product.setId("MOB_001");
	product.setName("iphone");
	product.setDescription("this is iphone");
	product.setPrice(5000);
	assertEquals("addProductTestCase",productDAO.save(product),true);	
}
@Test
public void listProductTestCase()
{
	assertEquals("addProductTestCase",productDAO.list().size(),2);
	}
}