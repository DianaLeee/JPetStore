package com.example.jpetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.BlackList;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
public class BlackListController { 
	
	private PetStoreFacade petStore;
	
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	/*
	 * 
	 * 	@RequestMapping("/shop/index.do")
	public String handleRequestC(
			ModelMap model
			) throws Exception {
		
		System.out.println("sense viewCategoryAll");
		model.addAttribute("resultList",this.petStore.selectBestList());
		return "index";
	}
	 * 
	 */

	@RequestMapping("/shop/blacklist.do")
	public ModelAndView blackList() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BlackList");
		mav.addObject("listOfBlack", this.petStore.getBlackList());
		return mav;
	}
	
	/*
	 	Item item = this.petStore.getItem(itemId); //DB¿¡¼­ item °´Ã¼¸¦ °¡Á®¿È 
		model.put("item", item);
		model.put("product", item.getProduct());
		return "Item";
	 */
	 
}
