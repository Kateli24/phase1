/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiaweili
 */
public class Totals {
    private double totalPrice;
    private double totalTax;
    private double totalPayment;
    private Sale sale;

    public Totals(double totalPrice, double totalTax, double totalPayment, Sale sale) {
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
        this.totalPayment = totalPayment;
        this.sale = sale;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public Sale getSale() {
        return sale;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Totals{" + "totalPrice=" + totalPrice + ", totalTax=" + totalTax + ", totalPayment=" + totalPayment + ", sale=" + sale + '}';
    }
    
    
    
    
}
