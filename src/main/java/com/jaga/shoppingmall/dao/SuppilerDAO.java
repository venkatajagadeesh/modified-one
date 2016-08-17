package com.jaga.shoppingmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jaga.shoppingmall.model.Suppiler;

@Repository
public interface SuppilerDAO {

public boolean save(Suppiler suppiler);
public boolean update(Suppiler suppiler);
public boolean delete(Suppiler suppiler);
public  Suppiler get(String id);
public  List<Suppiler> list();
	
	
}
