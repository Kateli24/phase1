/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Sale;
import domain.Summary;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jiaweili
 */
public class CustomerDAO {

    private static final Map<String, Customer> customers = new TreeMap<>();

    /**
     * A client needs to be able to get all sales for a specific customer
     *
     * @param id The ID of the customer.
     * @return The collection of sales matching the given customer ID, or null
     * if no match found.
     */
    public Collection<Sale> getSalesById(String id) {
        return customers.get(id).getSales();
    }

    /**
     * A client needs to be able to a summary of the sale data for a specific customer
     *
     * @param id The ID of the customer.
     * @return The summary matching the given customer ID, or null
     * if no match found.
     */
    public Summary getSummaryById(String id) {
        return customers.get(id).getSummary();

    }
    
    /**
	 * Checks if a customer exists.
	 *
	 * @param id The ID of the customer being checked.
	 * @return <code>true</code> if customer exists, <code>false</code> if not.
	 */
	public boolean exists(String id) {
		return customers.containsKey(id);
	}

}
