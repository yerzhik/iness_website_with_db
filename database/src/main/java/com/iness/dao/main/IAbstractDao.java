package com.iness.dao.main;

import com.iness.model.main.Abstract;

import java.util.List;

public interface IAbstractDao {
	List<Abstract> getAllAbstracts();
	List<Abstract> getAbstractsByType(boolean isOral);
}
