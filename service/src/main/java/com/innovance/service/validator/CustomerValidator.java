package com.innovance.service.validator;

import com.innovance.common.exception.ErrorMessageUtil;
import com.innovance.common.exception.MetaMessageUtil;
import com.innovance.entity.Customer;
import com.innovance.repository.CustomerRepository;
import com.innovance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    @Autowired
    CustomerRepository customerRepository;

    private MetaMessageUtil metaMessageUtil = new MetaMessageUtil();

    public void isValid(Customer customer) {
        metaMessageUtil = new MetaMessageUtil();

        if (customer.getCustomerId() == null) {
            Customer tempCustomer = customerRepository.findByCustomerNo(customer.getCustomerNo());
            if (tempCustomer != null)
                metaMessageUtil.addMetaMessageWarning( customer.getCustomerNo() + " nolu müşteri numarası sistemde mevcuttur..");
        }

        ErrorMessageUtil.checkBusinessException(metaMessageUtil);
    }
}
