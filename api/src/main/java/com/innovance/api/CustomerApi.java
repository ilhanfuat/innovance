package com.innovance.api;

import com.innovance.common.dto.ApiSuccess;
import com.innovance.common.dto.CustomerDto;
import com.innovance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerApi {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer-list")
    public ResponseEntity<?> retrieveCustomerList(){
        List<CustomerDto> customerDtoList = customerService.retrieveAllCustomers();
        return new ResponseEntity<>(new ApiSuccess("Listelendi",customerDtoList),HttpStatus.OK);
    }

    @PostMapping("/save-customer")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto){
        customerService.save(customerDto);
        return  new ResponseEntity<>(new ApiSuccess("Kayıt Başarılı",null), HttpStatus.OK);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerDto);
        return  new ResponseEntity<>(new ApiSuccess("Güncellendi",null), HttpStatus.OK);
    }


}
