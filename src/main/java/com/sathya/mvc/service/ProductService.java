package com.sathya.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.repository.ProductRepository;

import ch.qos.logback.core.model.Model;

@Service
public class ProductService {
	
	
		@Autowired
		ProductRepository productRepository;
		private ProductEntity productEntity;
		
		public void saveProductData(ProductModel productModel)
		{
			double price = productModel.getProPrice();
			String category = productModel.getProCategory();
			double ProDiscount = 0.0; 
			
			 switch (category.toLowerCase()) {
	         case "mobile":
	        	 ProDiscount = price * 0.1; 
	             break;
	         case "laptop":
	        	 ProDiscount = price * 0.15;
	             break;
	         case "printer":
	        	 ProDiscount = price * 0.2;
	             break;
	         case "camera":
	        	 ProDiscount = price * 0.25;
	             break;
			 }
			//Read the data from Model set the dqta to entity 
			 ProductEntity productEntity = new ProductEntity();
			 productEntity.setProName(productModel.getProName());
			 productEntity.setProPrice(productModel.getProPrice()); 
			 productEntity.setProCategory(productModel.getProCategory());
			 productEntity. setProDescription(productModel.getProDescription()); 
			 productEntity.setProBrand(productModel.getProBrand());

			 productEntity.setProDiscount(ProDiscount);
			 productEntity.setProCreatedAt(LocalDate.now());
			 productEntity.setProCreatedBy(System.getProperty("user.name"));

				 productRepository.save(productEntity);
}
		public List<ProductEntity> getALLProducts() {
			List<ProductEntity> products = productRepository.findAll(); 
			return products;
		}
		public ProductEntity getProductById(long proId) {
		    return productRepository.findById(proId).orElse(null);
		}
		public void deleteById(Long proId) {
			 productRepository.deleteById(proId);
			
		}
				public ProductModel getProductById(Long proId) {
					ProductEntity productEntity = productRepository.findById(proId).get();

					ProductModel productModel = new ProductModel();
					productModel.setProName(productEntity.getProName());
					productModel.setProBrand(productEntity.getProBrand());
					productModel.setProPrice(productEntity.getProPrice());
					productModel.setProCategory(productEntity.getProCategory());
					productModel.setProDescription(productEntity.getProDescription());

					return productModel;

				}
				
				public void updateProduct(Long proId, ProductModel productModel) {
			        // Fetch the existing product entity by ID
			        ProductEntity existingProduct = productRepository.findById(proId).get();

			        // Update the fields with values from the ProductModel
			        existingProduct.setProName(productModel.getProName());
			        existingProduct.setProBrand(productModel.getProBrand());
			        existingProduct.setProPrice(productModel.getProPrice());
			        existingProduct.setProDescription(productModel.getProDescription());
			        existingProduct.setProCategory(productModel.getProCategory());

			        // Save the updated product back to the repository
			        productRepository.save(existingProduct);
			    }
				}
				
				

