/**
 * @autor pathmasri
 * Feb 7, 2015 11:50:54 AM
 */
package org.zoro.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zoro.dto.constants.Constants;


@Controller
public class LoginController {

	@RequestMapping(value={"/","/login"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return Constants.LOGIN;
 
	}
 
	@RequestMapping(value="/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return Constants.LOGIN;
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) { 
		return Constants.LOGIN;
	}
}
