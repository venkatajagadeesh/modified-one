package com.jaga.ShoppingmallServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.shoppingmall.dao.SuppilerDAO;
import com.jaga.shoppingmall.dao.SuppilerDAO;
import com.jaga.shoppingmall.model.Category;
import com.jaga.shoppingmall.model.Suppiler;
import com.jaga.shoppingmall.model.Suppiler;

public class TestCaseSuppiler {

	@Autowired
	SuppilerDAO suppilerDAO;
	@Autowired
	Suppiler suppiler;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.jaga");
		context.refresh();
		suppilerDAO =(SuppilerDAO) context.getBean("suppilerDAO");
		suppiler= (Suppiler) context.getBean("suppiler");
	}
	@Test
	public void categoryListTestCase()
	{
		List<Suppiler> list = suppilerDAO.list();
		int rowCount= list.size();
		assertEquals("category Lisi Test case", rowCount,5);
     }
	@Test
	public void categoeyAddTestcase()
	{

		suppiler.setId("surfthjg");
		suppiler.setName("njsgd");
		suppiler.setAddress("werfcg");
		boolean flag= suppilerDAO.save(suppiler);
		assertEquals(flag, true);
	}
	@Test
	public void categoryGetTestCase()
	{
		suppiler = suppilerDAO.get("SUP001");
		
		System.out.println(suppiler.getAddress());
		System.out.println(suppiler.getName());
		assertEquals(suppiler.getName(),"asdfadge");
		
	}
}
