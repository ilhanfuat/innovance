package com.innovance.service.validator;

import com.innovance.common.dto.TransferDto;
import com.innovance.common.exception.ErrorMessageUtil;
import com.innovance.common.exception.MetaMessageUtil;
import com.innovance.entity.Account;
import com.innovance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountValidator {

    @Autowired
    AccountRepository accountRepository;

    private MetaMessageUtil metaMessageUtil = new MetaMessageUtil();

    public void checkBalance(TransferDto transferDto){
        metaMessageUtil = new MetaMessageUtil();
        Account sender = accountRepository.findByAccountId(transferDto.getSenderId());
        Account receiver = accountRepository.findByAccountId(transferDto.getReceiverId());
        if(!Objects.equals(sender.getCurrency(), receiver.getCurrency()))
            metaMessageUtil.addMetaMessageWarning("Sadece aynı para birimleri arasında transfer yapılabilir...");

        if(sender.getBalance()<transferDto.getAmount())
            metaMessageUtil.addMetaMessageWarning("Göndermek istediğiniz tutar toplam bakiyenizin üzerinde...");

        ErrorMessageUtil.checkBusinessException(metaMessageUtil);
    }
}
