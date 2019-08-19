package com.mandor.resep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mandor.resep.model.Product;
import com.mandor.resep.service.ProductService;


@Controller
public class IndexController {

	@Autowired
	private ProductService service;
	
	@RequestMapping({"", "/", "index"})
	public String getIndexPage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") long id) {
		service.delete(id);
		return "redirect:/";
	}
}
