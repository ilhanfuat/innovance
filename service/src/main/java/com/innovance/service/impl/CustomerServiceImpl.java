package com.innovance.service.impl;

import com.innovance.common.converter.CustomerConverter;
import com.innovance.common.dto.CustomerDto;
import com.innovance.entity.Customer;
import com.innovance.repository.CustomerRepository;
import com.innovance.service.CustomerService;
import com.innovance.service.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerValidator customerValidator;


    @Override
    public List<CustomerDto> retrieveAllCustomers()  {
        return CustomerConverter.convertToCustomerDtoList(customerRepository.findAll());
    }

    @Override
    public void save(Customer customer) {
        customerValidator.isValid(customer);
        customerRepository.save(customer);
    }

    @Override
    public void save(CustomerDto customerDto)  {
        save(CustomerConverter.convertToCustomerEntity(customerDto));
    }

    @Override
    @Transactional
    public void updateCustomer(CustomerDto customerDto) {
        customerRepository.updateCustomer(customerDto.getCustomerName(),customerDto.getCustomerSurname(),customerDto.getMailAddress(),customerDto.getCustomerId());
    }

    @Override
    public Customer retrieveCustomerByAccount(Short accountId) {
        return customerRepository.retrieveCustomerByAccount(accountId);
    }

}
