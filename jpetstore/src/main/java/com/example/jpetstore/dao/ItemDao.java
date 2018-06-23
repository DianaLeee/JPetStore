package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;

public interface ItemDao {

  public void updateQuantity(Order order) throws DataAccessException;

  boolean isItemInStock(String itemId) throws DataAccessException;

  List<Item> getItemListByProduct(String productId) throws DataAccessException;

  Item getItem(String itemId) throws DataAccessException;

  void insertItem(Item item) throws DataAccessException;
  
  void updateQuantityForInsertItem(Item item) throws DataAccessException;

  List<Item> getSellingItemListBySellerUsername(String username) throws DataAccessException;

  public void deleteItem(String itemId) throws DataAccessException;
  public void deleteItemInventory(String itemId) throws DataAccessException;
  public void deleteItemMyActivity(String itemId) throws DataAccessException;
}
