/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.bill;

import java.util.ArrayList;

/**
 *
 * @author RUBAL GARG
 */
public class BillCollectionReportModel 
{
    
    private ArrayList<BillItemModel> mItemList;
    private String FirstName;
    private String LastName,FirmName,Address,City,TinNo,ModeOfTransport,VehicleNumber,Fright;
    private String InvoiceNumber,Date;
    private String TotalNoOfSheets,GrandTotal,TaxLabel,TaxAmount,SurchareLabel,SurchageAmount,NetTotal,DiscountLabel,DiscountTotal,RoundOffValue,MainTotal,AmountInWords;
    
    public BillCollectionReportModel()
    {
        
    }
    public ArrayList<BillItemModel> getmItemList() {
        return mItemList;
    }

    public void setmItemList(ArrayList<BillItemModel> mItemList) {
        this.mItemList = mItemList;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirmName() {
        return FirmName;
    }

    public void setFirmName(String FirmName) {
        this.FirmName = FirmName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getTinNo() {
        return TinNo;
    }

    public void setTinNo(String TinNo) {
        this.TinNo = TinNo;
    }

    public String getModeOfTransport() {
        return ModeOfTransport;
    }

    public void setModeOfTransport(String ModeOfTransport) {
        this.ModeOfTransport = ModeOfTransport;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String VehicleNumber) {
        this.VehicleNumber = VehicleNumber;
    }

    public String getFright() {
        return Fright;
    }

    public void setFright(String Fright) {
        this.Fright = Fright;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTotalNoOfSheets() {
        return TotalNoOfSheets;
    }

    public void setTotalNoOfSheets(String TotalNoOfSheets) {
        this.TotalNoOfSheets = TotalNoOfSheets;
    }

    public String getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(String GrandTotal) {
        this.GrandTotal = GrandTotal;
    }

    public String getTaxLabel() {
        return TaxLabel;
    }

    public void setTaxLabel(String TaxLabel) {
        this.TaxLabel = TaxLabel;
    }

    public String getTaxAmount() {
        return TaxAmount;
    }

    public void setTaxAmount(String TaxAmount) {
        this.TaxAmount = TaxAmount;
    }

    public String getSurchareLabel() {
        return SurchareLabel;
    }

    public void setSurchareLabel(String SurchareLabel) {
        this.SurchareLabel = SurchareLabel;
    }

    public String getSurchageAmount() {
        return SurchageAmount;
    }

    public void setSurchageAmount(String SurchageAmount) {
        this.SurchageAmount = SurchageAmount;
    }

    public String getNetTotal() {
        return NetTotal;
    }

    public void setNetTotal(String NetTotal) {
        this.NetTotal = NetTotal;
    }

    public String getDiscountLabel() {
        return DiscountLabel;
    }

    public void setDiscountLabel(String DiscountLabel) {
        this.DiscountLabel = DiscountLabel;
    }

    public String getDiscountTotal() {
        return DiscountTotal;
    }

    public void setDiscountTotal(String DiscountTotal) {
        this.DiscountTotal = DiscountTotal;
    }

    public String getRoundOffValue() {
        return RoundOffValue;
    }

    public void setRoundOffValue(String RoundOffValue) {
        this.RoundOffValue = RoundOffValue;
    }

    public String getMainTotal() {
        return MainTotal;
    }

    public void setMainTotal(String MainTotal) {
        this.MainTotal = MainTotal;
    }

    public String getAmountInWords() {
        return AmountInWords;
    }

    public void setAmountInWords(String AmountInWords) {
        this.AmountInWords = AmountInWords;
    }
}
