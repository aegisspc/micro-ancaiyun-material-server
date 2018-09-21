package com.ancaiyun.responseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaserMaterial implements Serializable{
    private static final long serialVersionUID = 1L;

    //主键ID
    private String id;

    //创建时间
    private Date createTime;

    //删除标志位
    private String delFlag;

    //会员id
    private String memberId;

    //产品名称
    private String productName;

    //规格
    private String specificationsModel;

    //参数
    private String parameter;

    //品牌
    private String brand;

    //数量
    private BigDecimal purchaseQuantity;

    //计量单位
    private String unit;

    //其他描述
    private String description;

    //计量方式
    private String fillingType;

    //编码
    private String encoding;

    //单价
    private BigDecimal unitPrice;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public BigDecimal getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(BigDecimal purchaseQuantity) {
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

    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
