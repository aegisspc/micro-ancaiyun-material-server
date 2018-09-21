package com.ancaiyun.responseEntity;

import java.math.BigDecimal;

public class Material {
	private String productName; //物资名称
	
	private String specificationsModel; //规格型号

	private String parameter; //材质
	
	private String brand; //品牌

	private String fillingType; //计量方式

	private String unit; //单位

	private String purchaseQuantity; //数量

	private String bidderPrice; //单价

	private String pricescount; //金额（元）

	private String description; //备注

	public String getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(String bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public String getPricescount() {
		return pricescount;
	}

	public void setPricescount(String pricescount) {
		this.pricescount = pricescount;
	}

	public String getFillingType() {
		return fillingType;
	}

	public void setFillingType(String fillingType) {
		this.fillingType = fillingType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpecificationsModel() {
		return specificationsModel;
	}

	public void setSpecificationsModel(String specificationsModel) {
		this.specificationsModel = specificationsModel;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
