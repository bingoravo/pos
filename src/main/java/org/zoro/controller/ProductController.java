package org.zoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProducts() {
	return inventoryService.getAllProducts();
    }

}
