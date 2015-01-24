package org.zoro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zoro.dto.constants.Constants;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    InventoryService inventoryService;

    private static final Logger log = LoggerFactory
	    .getLogger(ProductController.class);

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProducts() {
	return inventoryService.getAllProducts();
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public @ResponseBody
    String saveProduct(@RequestBody Product product) {

	String result = Constants.SUCCESS;

	try {
	    log.info("Saving products");
	    inventoryService.addProduct(product);

	} catch (Exception e) {
	    result = "error";
	}

	return result;
    }
}
