package com.innovance.service;

import com.innovance.common.dto.AccountDto;
import com.innovance.common.dto.TransferDto;
import com.innovance.entity.Account;

import java.util.List;

public interface AccountService {

    List<AccountDto> retrieveAccountListByCustomer(Short customerId);

    void deleteAccount(Short accountId);

    void transferBalance(TransferDto transferDto);

    void save(Account account);
    void save(AccountDto accountDto);


}
