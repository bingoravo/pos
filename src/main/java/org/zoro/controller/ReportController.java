package org.zoro.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zoro.dto.UserSalesTO;

@Controller
@RequestMapping("/report/")
public class ReportController {

    @RequestMapping(value = "/userSales", method = RequestMethod.GET)
    public @ResponseBody
    List<String> userSales(@RequestParam UserSalesTO inputSalesTO) {
	return null;
    }

}
