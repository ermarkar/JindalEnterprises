/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.model;

/**
 *
 * @author RUBAL GARG
 */
public class StockModel 
{
    
    private String design_Id;
    private String thickness;
    private String finish;
    private int quantity;

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

    @Override
    public String toString() {
        return "StockModel{" + "design_Id=" + design_Id + ", thickness=" + thickness + ", finish=" + finish + ", quantity=" + quantity + '}';
    }
    
    
    
}
