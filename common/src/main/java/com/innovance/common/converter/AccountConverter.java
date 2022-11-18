package com.innovance.common.converter;

import com.innovance.common.dto.AccountDto;
import com.innovance.entity.Account;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountConverter {
    public static Account convertToAccountEntity(AccountDto accountDto) {
        Account account = new Account();
        BasicConverter.copyProperties(account, accountDto);
        if (accountDto.getCustomerDto() != null)
            account.setCustomer(CustomerConverter.convertToCustomerEntity(accountDto.getCustomerDto()));

        return account;
    }

    public static AccountDto convertToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        BasicConverter.copyProperties(accountDto, account);
        if (account.getCustomer() != null)
            accountDto.setCustomerDto(CustomerConverter.convertToCustomerDto(account.getCustomer()));
        return accountDto;

    }

    public static List<AccountDto> convertToAccountDtoList(List<Account> accountList) {
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account item : accountList) {
            accountDtoList.add(convertToAccountDto(item));
        }
        return accountDtoList;
    }

}
