package com.innovance.api;

import com.innovance.common.dto.AccountDto;
import com.innovance.common.dto.ApiSuccess;
import com.innovance.common.dto.CustomerDto;
import com.innovance.common.dto.TransferDto;
import com.innovance.entity.Account;
import com.innovance.entity.Customer;
import com.innovance.service.AccountService;
import com.innovance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    AccountService accountService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/account-list/{id}")
    public ResponseEntity<?> retrieveAccountList(@PathVariable("id") Short customerId) {
        List<AccountDto> accountDtoList = accountService.retrieveAccountListByCustomer(customerId);
        return new ResponseEntity<>(new ApiSuccess("Listelendi", accountDtoList), HttpStatus.OK);
    }

    @PostMapping("/save-account")
    public ResponseEntity<?> saveAccount(@RequestBody AccountDto accountDto){
        accountService.save(accountDto);
        return  new ResponseEntity<>(new ApiSuccess("Kayıt Başarılı",null), HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transferBalance(@RequestBody TransferDto transferDto) {

        Customer senderCustomer = customerService.retrieveCustomerByAccount(transferDto.getSenderId());
        Customer receiverCustomer = customerService.retrieveCustomerByAccount(transferDto.getReceiverId());
        if (!Objects.equals(senderCustomer.getCustomerId(), receiverCustomer.getCustomerId())) {
            accountService.transferBalance(transferDto);
            return new ResponseEntity<>(new ApiSuccess(senderCustomer.getCustomerName() + " " + senderCustomer.getCustomerSurname() + " adlı kullanıcından hesabınıza para transferi gerçekleştirildi", null), HttpStatus.OK);
        } else {
            accountService.transferBalance(transferDto);
            return new ResponseEntity<>(new ApiSuccess("Transfer Gerçekleştirildi", null), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Short accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(new ApiSuccess("Silindi", null), HttpStatus.OK);
    }

}
