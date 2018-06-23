package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.ItemForm;
import com.example.jpetstore.domain.Item;

@Component
public class ItemValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		validateItemFields((Item) obj, errors);
	}
	public void validateItemFields(Item item, Errors errors) {
		errors.setNestedPath("item");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product.name", "PRODUCT_NAME_REQUIRED", "Product name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "LISTPRICE_REQUIRED", "List Price is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "attribute1", "ATTRIBUTE1_REQUIRED", "Attribute1 is required.");
		errors.setNestedPath("");
	}

}
