package com.innovance.common.dto;

import com.innovance.common.constant.SeverityConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError extends ApiResponse {

    public ApiError() {
        super();
        setSeverity(SeverityConstant.ERROR);
        setLife(10000);
    }

}