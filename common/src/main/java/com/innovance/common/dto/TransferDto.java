package com.innovance.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferDto {
    @JsonProperty("sender_id")
    private Short senderId;

    @JsonProperty("receiver_id")
    private Short receiverId;

    @JsonProperty("amount")
    private Integer amount;
}
