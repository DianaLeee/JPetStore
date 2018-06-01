package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.BlackList;


public interface BlackListDao {
	public List<BlackList> getBlackList() throws DataAccessException;
}
