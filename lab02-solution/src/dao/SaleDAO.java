/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Sale;
import domain.Summary;
import domain.Totals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author jiaweili
 */
public class SaleDAO {

    private static final Map<String, ArrayList<Sale>> sales = new TreeMap<String, ArrayList<Sale>>();
    private static final Map<String,Summary> summaries = new TreeMap<>();
    

    /*
	 * Some dummy data for testing
     */

    public SaleDAO() {
         ArrayList<Sale> sample = new ArrayList<Sale>();
          Sale sale = new Sale("01", "20100319", "api/sales/customer/WD1234",
                    new Customer("WD1234", "Kate", "Li", "kateli24@outlook.com"),
                    new Totals(35.5, 1.5, 37.0));
            sample.add(sale);
            sales.put("WD1234", sample);
        
    }
    
        
         
    

    /**
     * A client needs to be able to add a new sale.
     *
     * @param customerId the customer ID.
     * @param newSale The sale being added.
     */
    public void addSale(String customerId, Sale newSale) {
        ArrayList<Sale> salesByCustomer = sales.get(customerId);
        salesByCustomer.add(newSale);
    }


    /**
     * A client needs to be able to get all sales for a specific customer
     *
     * @param id The ID of the customer.
     * @return The collection of sales matching the given customer ID, or null
     * if no match found.
     */
    public Collection<Sale> getSalesById(String id) {
        return sales.get(id);
    }

    /**
     * A client needs to be able to a summary of the sale data for a specific
     * customer
     *
     * @param id The ID of the customer.
     * @return The summary matching the given customer ID, or null if no match
     * found.
     */
    public Summary getSummaryById(String id) {
        return summaries.get(id);
        

    }

    /**
     * Checks if a customer exists.
     *
     * @param id The ID of the customer being checked.
     * @return <code>true</code> if customer exists, <code>false</code> if not.
     */
    public boolean ifCustomerExists(String id) {
        return sales.containsKey(id);
    }

}
