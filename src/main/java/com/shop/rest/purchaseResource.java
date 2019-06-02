package com.shop.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.domain.enums.ProductType;
import com.shop.domain.model.response.ProductDTO;

@RestController
@RequestMapping("purchase/v1")
public class purchaseResource {

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductDTO> getAvailableItems(

			@RequestParam(value = "product") ProductType product) {

		return new ResponseEntity<>(new ProductDTO(), HttpStatus.OK);

	}
}
