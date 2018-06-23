package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Item;

//ItemForm : 아이템 정보를 입력 받아 저장할 객체 
@SuppressWarnings("serial")
public class ItemForm implements Serializable {
	
	private final Item item = new Item();
//	private boolean newItem;
	
	public Item getItem() {
		return item;
	}
	
//	public ItemForm(Item item) {
//		this.item = item;
//		this.newItem = false;
//	}
//	
//	public ItemForm() {
//		this.item = new Item();
//		this.newItem = true;
//	}
//	

//	public boolean isNewItem() {
//		return newItem;
//	}
	

}
