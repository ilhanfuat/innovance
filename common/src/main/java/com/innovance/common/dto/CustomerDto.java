package com.innovance.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    @JsonProperty("customer_id")
    private Short customerId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_surname")
    private String customerSurname;

    @JsonProperty("mail_address")
    private String mailAddress;

    @JsonProperty("customer_no")
    private String customerNo;


}
