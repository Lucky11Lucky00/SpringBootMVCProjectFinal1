package com.sathya.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;

import jakarta.validation.Valid;
 
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    //get the productform
    @GetMapping("/productform")
    public String getProducts(Model model) {
        // Provide the form with an empty object
        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel", productModel);
        model.addAttribute("page", "productform");
    	return "index";
    }
    //save the data
    @PostMapping("/products")
    public String saveProduct( @Valid ProductModel productModel,BindingResult bindingResult ,Model model) {
    	if (bindingResult.hasErrors()) {
    		return "add-product";
    	}
        productService.saveProductData(productModel);
        return "success";
 
    }
    //get data 
    @GetMapping("/getProducts")
    public String getProduct(Model model) {
        List<ProductEntity> products = productService.getALLProducts();
        model.addAttribute("products", products); 
        model.addAttribute("page", "getProducts");
    	return "index"; 
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("proId") Long proID) {
        productService.deleteById(proID);  
        return "redirect:/getProducts";  
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long proId, Model model) {
        // Fetch the product by ID and add it to the model
        ProductModel productModel = productService.getProductById(proId);
        model.addAttribute("productModel", productModel);
        model.addAttribute("categories", Arrays.asList("Mobile", "Camera", "Printer", "Laptop", "Accessories"));

        model.addAttribute("proId", proId);
        
        return "edit-product";  
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute ProductModel productModel, 
    							@RequestParam Long proId) {
    	productService.updateProduct(proId, productModel);

    	return "redirect:/getProducts";  
    }
    @GetMapping("/contact")
    public String showContactForm(Model model) {
    	model.addAttribute("page","contact");
        return "Index"; 
    }
    @GetMapping("/about")
    public String showAboutPage(Model model) {
    	model.addAttribute("page","about");
        return "Index"; 
    }
    
    @GetMapping("/searchform")
	 public String getSearchForm(Model model) {
		 ProductModel productModel = new ProductModel();
	     model.addAttribute("productModel", productModel);
	     model.addAttribute("page","searchform");
	     return "index"; 
	 }
    
	 @GetMapping("/searchProduct")
	 public String searchProduct(@RequestParam long proId, Model model) {
	     ProductEntity product = productService.getProductById(proId);
	     if (product != null) {
	         model.addAttribute("product", product);
	     } else {
	         model.addAttribute("error", "Product not found!");
	     }
	     model.addAttribute("page","searchProduct");
	     return "index";
	}
    @GetMapping("/")
    public String getHomepage()
   {
	return "index";
}
	}