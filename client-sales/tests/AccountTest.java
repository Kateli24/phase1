/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import api.CustomerApi;
import api.CustomersApi;
import domain.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import retrofit2.Call;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author jiaweili
 */
public class AccountTest {
    
     Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8082/api/customers/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
     
     CustomerApi customerApi;
     CustomersApi customersApi;
     Customer customer;
    
     
    
    public AccountTest() {
    }
    
//    @BeforeClass
//    public  void setUpClass() {
//     
//    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp(){
        customerApi = retrofit.create(CustomerApi.class);
        customersApi = retrofit.create(CustomersApi.class);
        
        customer = new Customer();
        customer.setUserName("Sssz");
        customer.setFirstName("sam");
        customer.setLastName("Smith");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void getCustomers() throws IOException {
        List<Customer> customers = customersApi.getCustomers().execute().body();
        assertTrue(customers.size()==3);
    }
    
    @Test
    public void postCustomer() throws IOException{
        customersApi.postACustomer(customer);
        
        
      
        List<Customer> customers = customersApi.getCustomers().execute().body();
                System.out.print("Customers="+customers);

//        for(Customer c:customers){
//             System.out.print("Username=="+c.getUserName()+(customer.getUserName()));
//            if(c.getUserName().equals(customer.getUserName())){
//               
//                assertTrue(c.equals(customer));
//                
//            }else{
//                assertTrue(c.equals(customer));
//            }
//        }
        System.out.println("Index=" + customers.indexOf(customer));
        assertEquals("Customer is saved", customers.get(0));
        

    }
}