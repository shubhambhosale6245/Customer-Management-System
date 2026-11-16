package com.cust.customerproject.customerservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cust.customerproject.entity.Customer;
import com.cust.customerproject.exception.CustomerNotFoundException;
import com.cust.customerproject.repository.CustomerRepository;

@Service
public class CustomerService1 implements CustomerService {

    private final CustomerRepository repository;

    public CustomerService1(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return repository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with ID : " + customerId));
    }

    @Override
    public Customer updateCustomer(Integer customerId, Customer customer) {

        Customer oldCustomer = repository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with ID : " + customerId));

        oldCustomer.setCustomerName(customer.getCustomerName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setCity(customer.getCity());

        return repository.save(oldCustomer);
    }

    @Override
    public String deleteCustomer(Integer customerId) {

        Customer customer = repository.findById(customerId)
        		.orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with ID : " + customerId));

        repository.delete(customer);

        return "Customer deleted successfully.";
    }
}