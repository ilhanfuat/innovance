package com.innovance.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "account")
public class Account {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    Short accountId;

    @Column(name = "balance")
    Integer balance;

    @Column(name = "currency")
    String currency;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
