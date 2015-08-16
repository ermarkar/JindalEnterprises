/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.stockReport;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author RUBAL GARG
 */
public class StockReportModel
{
    private ArrayList<KnownStockModel> knownStock;
    private ArrayList<UnknownStockModel> unKnownStock;
    private ArrayList<TotalStockModel> totalStock;
    private int grandTotal;
    
    public ArrayList<KnownStockModel> getKnownStock() {
        return knownStock;
    }

    public void setKnownStock(ArrayList<KnownStockModel> knownStock) {
        this.knownStock = knownStock;
    }

    public ArrayList<UnknownStockModel> getUnKnownStock() {
        return unKnownStock;
    }

    public void setUnKnownStock(ArrayList<UnknownStockModel> unKnownStock) {
        this.unKnownStock = unKnownStock;
    }

    public ArrayList<TotalStockModel> getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(ArrayList<TotalStockModel> totalStock) {
        this.totalStock = totalStock;
    } 

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }
}
