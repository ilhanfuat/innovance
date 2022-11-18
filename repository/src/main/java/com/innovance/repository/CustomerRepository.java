package com.innovance.repository;

import com.innovance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Short> {

    @Modifying
    @Query("UPDATE Customer c SET c.customerName =:name,c.customerSurname=:surname,c.mailAddress=:mail WHERE c.customerId = :customerId")
    void updateCustomer(@Param("name") String name, @Param("surname") String surname,@Param("mail") String mail,@Param("customerId") Short customerId);

    @Query("select a.customer from Account a where a.accountId=:accountId")
    Customer retrieveCustomerByAccount(@Param("accountId") Short accountId);

    Customer findByCustomerNo(String customerNo);

}
