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
public class TotalStockModel {
    private HashMap<Integer,Integer> totalQuantityPerFinish;

    public TotalStockModel() {
    }
    
    public TotalStockModel(HashMap<Integer, Integer> totalQuantityPerFinish) {
        this.totalQuantityPerFinish = totalQuantityPerFinish;
    }
    
    public HashMap<Integer,Integer> getTotalQuantityPerFinish() {
        return totalQuantityPerFinish;
    }

    public void setTotalQuantityPerFinish(HashMap<Integer,Integer> totalQuantityPerFinish) {
        this.totalQuantityPerFinish = totalQuantityPerFinish;
    }
    
    
}
