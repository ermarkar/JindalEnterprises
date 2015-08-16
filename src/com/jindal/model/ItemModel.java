/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.model;

import java.util.Date;

/**
 *
 * @author RUBAL GARG
 */
public class ItemModel {
    String design_Id;
    String thickness;
    String finish;
    int quantity;
    double rate;
    String size;
    double price;
    private Date modifyStock;
    private int rowCount;
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public ItemModel() {
    }

    public ItemModel(String design_Id, String thickness, String finish, int quantity, double rate, String size, double price) {
        this.design_Id = design_Id;
        this.thickness = thickness;
        this.finish = finish;
        this.quantity = quantity;
        this.rate = rate;
        this.size = size;
        this.price = price;
    }

    

    
    public String getDesign_Id() {
        return design_Id;
    }

    public void setDesign_Id(String design_Id) {
        this.design_Id = design_Id;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "design_Id=" + design_Id + ", thickness=" + thickness + ", finish=" + finish + ", quantity=" + quantity + ", rate=" + rate + ", size=" + size + ", price=" + price + '}';
    }

    public Date getModifyStock() {
        return modifyStock;
    }

    public void setModifyStock(Date modifyStock) {
        this.modifyStock = modifyStock;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    

}
