/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.stockReport;

import java.util.HashMap;

/**
 *
 * @author RUBAL GARG
 */
public class KnownStockModel 
{
    private String designId;
    private HashMap<Integer,String> quantity;
    private int totalQuantity;
    private HashMap<Integer,String> totalQuantityPerItem;

    public KnownStockModel() {
    }

    public KnownStockModel(String designId, HashMap<Integer, String> quantity, int totalQuantity, HashMap<Integer, String> totalQuantityPerItem) {
        this.designId = designId;
        this.quantity = quantity;
        this.totalQuantity = totalQuantity;
        this.totalQuantityPerItem = totalQuantityPerItem;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }

    public HashMap<Integer,String> getQuantity() {
        return quantity;
    }

    public void setQuantity(HashMap<Integer,String> quantity) {
        this.quantity = quantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public HashMap<Integer,String> getTotalQuantityPerItem() {
        return totalQuantityPerItem;
    }

    public void setTotalQuantityPerItem(HashMap<Integer,String> totalQuantityPerItem) {
        this.totalQuantityPerItem = totalQuantityPerItem;
    }
    
    
}
