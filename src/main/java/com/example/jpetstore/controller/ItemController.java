package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.jpetstore.service.ItemValidator;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@SessionAttributes("itemForm")
public class ItemController {
	@Autowired
	private PetStoreFacade petStore;
	
	@Autowired
	private ItemValidator itemValidator;
	
	@ModelAttribute("itemForm") 
	public ItemForm createItemForm() {
		return new ItemForm();
	}
	
	@ModelAttribute("categoryNames")  
	public List<String> referenceData() {
		ArrayList<String> categoryNames = new ArrayList<String>();
		categoryNames.add("FISH");
		categoryNames.add("DOGS");
		categoryNames.add("REPTILES");
		categoryNames.add("CATS");
		categoryNames.add("BIRDS");
		
		return categoryNames;
	}
	
	@ModelAttribute("productNames") 
	public List<String> referenceData2() {
		ArrayList<String> productNames = new ArrayList<String>();
		productNames.add("Angelfish");
		productNames.add("Tiger Shark");
		productNames.add("Koi");
		productNames.add("Goldfish");
		productNames.add("Bulldog");
		productNames.add("Poodle");
		productNames.add("Dalmation");
		productNames.add("Golden Retriever");
		productNames.add("Labrador Retriever");
		productNames.add("Chihuahua");
		productNames.add("Rattlesnake");
		productNames.add("Iguana");
		productNames.add("Manx");
		productNames.add("Persian");
		productNames.add("Amazon Parrot");
		productNames.add("Finch");

		return productNames;
	}
	
	@RequestMapping("/shop/addItem.do") //addItem.do�쓽 �슂泥� mapping 
	public String addNewItem(HttpServletRequest request,
			@ModelAttribute("itemForm") ItemForm itemForm //ItemForm.java -> �븘�씠�뀥 �젙蹂대�� ���옣�븷 媛앹껜. �씠 �븞�뿉 Item 媛앹껜 議댁옱. 
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if(userSession != null) { //UserSession�씠 �엳�뒗 寃쎌슦-> 濡쒓렇�씤 �븿. NewItemForm�쓣 return;
			return "NewItemForm";
		}
		else { 
			//UserSession �씠 �뾾�뒗 寃쎌슦 -> 濡쒓렇�씤 �븯吏� �븡�쑝硫� 臾쇳뭹 �벑濡앹쓣 �븯吏� 紐삵븯�룄濡� 留됱쓬 
			//�뿉�윭硫붿꽭吏� 異쒕젰�븯寃�
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "臾쇳뭹�쓣 �벑濡앺븯�떆�젮硫� 癒쇱� 濡쒓렇�씤 �븯�꽭�슂");
			System.out.println(modelAndView);
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping("/shop/newItemSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("itemForm") ItemForm itemForm,
			BindingResult result) {
		//User �씠由꾩씠 �쟾�떖�씠 �븞�릺�뼱�꽌 吏��젙�빐以�  
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		itemForm.getItem().setSellerUsername(userSession.getAccount().getUsername());

		itemValidator.validateItemFields(itemForm.getItem(), result);

		if(result.hasErrors()) {
			return "NewItemForm";
		}
		else {
			return "confirmAddItem";
		}
	}
	
	@RequestMapping("/shop/confirmAddItem.do")
	protected ModelAndView confirmAddItem(
			@ModelAttribute("itemForm") ItemForm itemForm,
			SessionStatus status) {
		//�떎�젣 �궫�엯 
		petStore.insertItem(itemForm.getItem());
		ModelAndView mav =  new ModelAndView("ViewAddedItem");
		mav.addObject("addedItem", itemForm.getItem());
		mav.addObject("message", "Thank you, your item has been added.");
		status.setComplete();
		return mav;
	}
	
	/**
	 * Added June 1st, 2018
	 * Showing list of my selling items
	 */
	@RequestMapping("/shop/listSellingItems.do")
	public ModelAndView handleRequest(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if(userSession != null) {
			String username = userSession.getAccount().getUsername();
			System.out.println(username + " hello!");
			return new ModelAndView("ListSellingItems", "sellingItemList", 
					petStore.getSellingItemListBySellerUsername(username));
		} else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "臾쇳뭹�쓣 �솗�씤�븯�떆�젮硫� 癒쇱� 濡쒓렇�씤 �븯�꽭�슂");
			System.out.println(modelAndView);
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	
	
}
