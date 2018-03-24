/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author jiaweili
 */
public class AccountTest {
    
    private final Customer customer1  = new Customer("sammy", "sam", "smith", "samsmith@outlook.com", "regular customer", "api/customers/customer/sam");
    private final Customer customer2  = new Customer("vivi", "vicky", "smith", "vickysmith@outlook.com", "VIP", "api/customers/customer/vivi");
    
    WebTarget customer; 
    public AccountTest() {
    }
    
    @BeforeClass
    public  void setUpClass() {
     //   customer = ClientBuilder.newClient().target("http://localhost:8082/api");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
