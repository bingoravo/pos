package org.zoro.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zoro.dto.BookingCart;
import org.zoro.dto.ProductList;
import org.zoro.dto.constants.Constants;
import org.zoro.exception.ModuleException;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

@Controller
@RequestMapping("/sales/")
public class SalesController {

    private static final Logger log = LoggerFactory
	    .getLogger(SalesController.class);

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/searchProducts", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductList> searchProducts(@RequestParam String searchCode) {
	log.info("get prodcuts start");
	List<ProductList> porductList = inventoryService
		.searchProducts(searchCode);
	return porductList;
    }

    @RequestMapping(value = "getProductDetails", method = RequestMethod.GET)
    public @ResponseBody
    Product getProductDetails(@RequestParam String productName) {
	return inventoryService.getProductDetails(productName);
    }

    @RequestMapping(value = "getBookingCart", method = RequestMethod.POST)
    @ResponseBody
    BookingCart getBookingCart(@RequestBody Map<String, String> cartDetails) {
	return inventoryService.populateBookigCart(cartDetails);
    }

    @RequestMapping(value = "purchase", method = RequestMethod.POST)
    @ResponseBody
    public String purchase(@RequestBody Map<String, String> cartDetails) {

	String result = Constants.DEFAULT_SUCCESS;

	try {
	    String userId = "SYSTEM";
	    inventoryService.purchase(cartDetails, userId);
	} catch (ModuleException me) {
	    log.error("Module Exception in purchase " + me);
	    result = me.getMessage();
	} catch (Exception e) {
	    log.error("Excepion in purchase " + e);
	    result = Constants.DEFAULT_ERROR;
	}
	return result;

    }
}
