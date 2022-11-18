package com.innovance.repository;

import com.innovance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Short> {
    @Query(value ="select a from Account a where a.customer.customerId=:customerId")
    List<Account> retrieveAccountListByCustomer(@Param("customerId") Short customerId);

    @Modifying
    @Query(value = "delete from Account a where a.accountId = :accountId")
    void deleteAccount(@Param("accountId") Short accountId);

    Account findByAccountId(Short accountId);

    @Modifying
    @Query(value = "update Account set  balance = :balance where accountId=:accountId ")
    void updateBalance(@Param("accountId") Short accountId,@Param("balance") Integer balance);



}
