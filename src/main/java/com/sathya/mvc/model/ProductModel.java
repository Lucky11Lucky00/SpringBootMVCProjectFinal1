package com.sathya.mvc.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	
	public long getProId() {
		return proId;
	}
	public void setProId(long proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	private  long proId;
	 @NotBlank(message = "Product name is required.")
	    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters.")
	private String proName;
	    @NotNull(message = "Product price is required.")
	    @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be greater than zero.")
	private double proPrice;
	    @NotBlank(message = "Product description is required.")
	    @Size(max = 200, message = "Description should not exceed 200 characters.")
	private String proDescription;
	    @NotBlank(message = "Product brand is required.")
	    @Size(max = 50, message = "Product brand should not exceed 50 characters.")
	private String proBrand;
	    @NotBlank(message = "Product category is required.")
	    @Size(max = 30, message = "Product category should not exceed 30 characters.")
	private String proCategory;

	
}

