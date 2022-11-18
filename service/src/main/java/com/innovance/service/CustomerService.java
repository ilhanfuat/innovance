package com.innovance.service;

import com.innovance.common.dto.CustomerDto;
import com.innovance.entity.Customer;
import java.util.List;

public interface CustomerService {

    List<CustomerDto> retrieveAllCustomers();

    void save(Customer customer);
    void save(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);
    Customer retrieveCustomerByAccount(Short accountId);
}
