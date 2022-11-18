package com.innovance.service.impl;

import com.innovance.common.converter.AccountConverter;
import com.innovance.common.dto.AccountDto;
import com.innovance.common.dto.TransferDto;
import com.innovance.entity.Account;
import com.innovance.repository.AccountRepository;
import com.innovance.service.AccountService;
import com.innovance.service.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountValidator accountValidator;

    @Override
    public List<AccountDto> retrieveAccountListByCustomer(Short customerId) {
        return AccountConverter.convertToAccountDtoList(accountRepository.retrieveAccountListByCustomer(customerId));
    }

    @Override
    @Transactional
    public void deleteAccount(Short accountId) {
        accountRepository.deleteAccount(accountId);
    }

    @Override
    @Transactional
    public void transferBalance(TransferDto transferDto) {
        accountValidator.checkBalance(transferDto);
        Account senderAccount = accountRepository.findByAccountId(transferDto.getSenderId());
        Account receiverAccount = accountRepository.findByAccountId(transferDto.getReceiverId());
        Integer senderNewBalance = senderAccount.getBalance() - transferDto.getAmount();
        Integer receiverNewBalance = receiverAccount.getBalance() + transferDto.getAmount();
        accountRepository.updateBalance(transferDto.getSenderId(), senderNewBalance);
        accountRepository.updateBalance(transferDto.getReceiverId(), receiverNewBalance);

    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void save(AccountDto accountDto) {
        save(AccountConverter.convertToAccountEntity(accountDto));

    }
}
