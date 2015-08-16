/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author RUBAL GARG
 */
public class SalesOrderModel {
    private int invoiceNumber;
    private ArrayList<ItemModel> items;
    private CustomerServiceModel customerObj;
    private double tax;
    private double taxValue;
    private double surcharge;
    private double surchargeValue;
    private double discount;
    private double freight;
    private double grandTotal;
    private double netTotal;
    private String transportMode;
    private String vehicle;
    private Date orderDate;
        private double DiscountValue;
    private boolean IsAmountselected;
    private boolean IsVatselected;

    public double getDiscountValue() {
        return DiscountValue;
    }

    public void setDiscountValue(double DiscountValue) {
        this.DiscountValue = DiscountValue;
    }

    public boolean isIsAmountselected() {
        return IsAmountselected;
    }

    public void setIsAmountselected(boolean IsAmountselected) {
        this.IsAmountselected = IsAmountselected;
    }

        
    
    public ArrayList<ItemModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemModel> items) {
        this.items = items;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public CustomerServiceModel getCustomerObj() {
        return customerObj;
    }

    public void setCustomerObj(CustomerServiceModel customerObj) {
        this.customerObj = customerObj;
    }

    @Override
    public String toString() {
        return "SalesOrderModel{" + "invoiceNumber=" + invoiceNumber + ", items=" + items + ", customerObj=" + customerObj + ", tax=" + tax + ", taxValue=" + taxValue + ", surcharge=" + surcharge + ", surchargeValue=" + surchargeValue + ", discount=" + discount + ", freight=" + freight + ", grandTotal=" + grandTotal + ", netTotal=" + netTotal + ", transportMode=" + transportMode + ", vehicle=" + vehicle + ", orderDate=" + orderDate + '}';
    }

    
    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public double getSurchargeValue() {
        return surchargeValue;
    }

    public void setSurchargeValue(double surchargeValue) {
        this.surchargeValue = surchargeValue;
    }
    
    public void setVatSelected(boolean isVat)
    {
        this.IsVatselected=isVat;
    }
    public boolean isVatSelected()
    {
     return IsVatselected;   
    }
}