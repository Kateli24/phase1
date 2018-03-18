/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Product;
import domain.Sale;
import domain.SaleItem;
import domain.Totals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jiaweili
 */
public class SaleDAO {
    

	private static final Map<String, Sale> sales = new TreeMap<>();

	/*
	 * Some dummy data for testing
	 */
	static {
		if (sales.isEmpty()) {
			sales.put("WD1234", new Sale("WD1234", "20100319", "api/sales/WD1234", 
                                new Customer("01","Kate","Li","kateli24@outlook.com"), 
                                new Totals(35.5,1.5,37.0)));
		}
	}
        
        /**
	 * A client needs to be able to add a new sale.
	 *
	 * @param newSale The sale being added.
	 */
	public void addSale(Sale newSale) {
		sales.put(newSale.getId(), newSale);
	}
        
        

	
	/**
	 * Checks if a product exists.
	 *
	 * @param id The ID of the product being checked.
	 * @return <code>true</code> if product exists, <code>false</code> if not.
	 */
	public boolean exists(String id) {
		return sales.containsKey(id);
	}

}


