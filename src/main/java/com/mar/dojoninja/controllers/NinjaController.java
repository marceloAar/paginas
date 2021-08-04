//Marcelo Aceituno R
//Full Stack JAva 0034
//Dojos y Ninjas
package com.mar.dojoninja.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.dojoninja.models.Ninja;
import com.mar.dojoninja.services.DojoService;
import com.mar.dojoninja.services.NinjaService;

@Controller
public class NinjaController {	
	
	private final NinjaService ninjaService;	

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		
	}	
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    
		Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	   
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}
}
