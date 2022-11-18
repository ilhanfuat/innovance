package com.innovance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
public class Customer  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Short customerId;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "customer_surname")
    String customerSurname;

    @Column(name = "mail_address")
    String mailAddress;

    @Column(name= "customer_no")
    String customerNo;

}
