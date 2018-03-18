/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Product;
import domain.Sale;
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
	 * A client needs to be able to get a customer by ID.
	 *
	 * @param id An ID of a customer.
         * @return The customer 
	 */
   public Customer getCustomerById(String id) {
            if(customers.containsKey(id)==true){
                return customers.get(id);
            }
            else{
                return null;
            }
   }
}

 
	
		
	
    

