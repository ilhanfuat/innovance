package com.innovance.common.converter;

import com.innovance.common.dto.CustomerDto;
import com.innovance.entity.Customer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerConverter {
        public  static Customer convertToCustomerEntity(CustomerDto customerDto){
            Customer customer= new Customer();
            BasicConverter.copyProperties(customer,customerDto);
            return customer;
        }

        public static CustomerDto convertToCustomerDto(Customer customer){
            CustomerDto customerDto = new CustomerDto();
            BasicConverter.copyProperties(customerDto,customer);
            return customerDto;

        }

        public static List<CustomerDto> convertToCustomerDtoList(List<Customer> customerList){
            List<CustomerDto> customerDtoList=new ArrayList<>();
            for (Customer item : customerList){
                customerDtoList.add(convertToCustomerDto(item)); }
            return customerDtoList;
        }

}
