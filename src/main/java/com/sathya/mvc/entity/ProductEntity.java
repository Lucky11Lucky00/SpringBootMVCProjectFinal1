
package com.sathya.mvc.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	private long proId;
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
		public String getProBrand() {
			return proBrand;
		}
		public void setProBrand(String proBrand) {
			this.proBrand = proBrand;
		}
		public Double getProDiscount() {
			return proDiscount;
		}
		public void setProDiscount(Double proDiscount) {
			this.proDiscount = proDiscount;
		}
		public String getProDescription() {
			return proDescription;
		}
		public void setProDescription(String proDescription) {
			this.proDescription = proDescription;
		}
		public String getProCategory() {
			return proCategory;
		}
		public void setProCategory(String proCategory) {
			this.proCategory = proCategory;
		}
		public LocalDate getProCreatedAt() {
			return proCreatedAt;
		}
		public void setProCreatedAt(LocalDate proCreatedAt) {
			this.proCreatedAt = proCreatedAt;
		}
		public String getProCreatedBy() {
			return proCreatedBy;
		}
		public void setProCreatedBy(String proCreatedBy) {
			this.proCreatedBy = proCreatedBy;
		}
	private String proName;
	private double proPrice;
	private String proBrand;
	private Double proDiscount;
	//private String proImage;
	private String proDescription;
	private String proCategory;
	private LocalDate proCreatedAt;
	private String proCreatedBy;
	
		
	}
	
