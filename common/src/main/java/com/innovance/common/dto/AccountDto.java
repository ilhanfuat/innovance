package com.innovance.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    @JsonProperty("account_id")
    private Short accountId;

    @JsonProperty("balance")
    private Integer balance;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("customer")
    private CustomerDto customerDto;
}
