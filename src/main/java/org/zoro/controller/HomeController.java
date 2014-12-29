package org.zoro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zoro.dto.productList;
import org.zoro.dto.constants.JSPNames;
import org.zoro.service.InventoryService;
import org.zoro.service.impl.InventoryServiceImpl;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private InventoryService inventoryService = new InventoryServiceImpl();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");

		return JSPNames.HOME;
	}

	@RequestMapping(value = "/productDetails", method = RequestMethod.GET)
	public ModelAndView getProductDetails() {
		logger.info("get prodcuts start");
		ModelAndView mv = new ModelAndView("productList");
		List<productList> porductList = inventoryService.searchProducts("ri");
		mv.addObject("productList", porductList);
		logger.info("get prodcuts end");
		return mv;
	}

}
