package com.mandor.resep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(name = "id") long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditProdcutEditPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Optional<Product> product = service.getProduct(id);
		mav.addObject("product", product);
		
		return mav;
	}
}
