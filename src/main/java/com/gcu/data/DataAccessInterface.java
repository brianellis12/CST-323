package com.gcu.data;

import java.util.List;

public interface DataAccessInterface <T>
{
	public List<T> findAll();

	public boolean create(T t);
	
}
