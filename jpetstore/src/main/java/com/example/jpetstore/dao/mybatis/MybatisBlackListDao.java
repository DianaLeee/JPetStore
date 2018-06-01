package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.BlackListDao;
import com.example.jpetstore.domain.BlackList;
import com.example.jpetstore.dao.mybatis.mapper.BlackListMapper;

@Repository
public class MybatisBlackListDao implements BlackListDao {

	@Autowired
	private BlackListMapper BlackListMapper;
	
	public List<BlackList> getBlackList() throws DataAccessException{
		return BlackListMapper.getBlackList();
	}
	
	/*
	public List<Item> getItemListByProduct(String productId) 
			throws DataAccessException {
		return itemMapper.getItemListByProduct(productId);
	}*/
}
