/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.bill;

/**
 *
 * @author RUBAL GARG
 */
public class BillItemModel {
        String SerailNumber,ItemName,NoOfSheets,RatePerSheet,TotalAmount;

    public String getSerailNumber() {
        return SerailNumber;
    }

    public void setSerailNumber(String SerailNumber) {
        this.SerailNumber = SerailNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getNoOfSheets() {
        return NoOfSheets;
    }

    public void setNoOfSheets(String NoOfSheets) {
        this.NoOfSheets = NoOfSheets;
    }

    public String getRatePerSheet() {
        return RatePerSheet;
    }

    public void setRatePerSheet(String RatePerSheet) {
        this.RatePerSheet = RatePerSheet;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

}
