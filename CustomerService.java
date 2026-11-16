package com.cust.customerproject.customerservices;

import java.util.List;

import com.cust.customerproject.entity.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer customerId);

    Customer updateCustomer(Integer customerId, Customer customer);

    String deleteCustomer(Integer customerId);

}