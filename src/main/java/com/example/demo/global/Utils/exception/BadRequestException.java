package com.example.demo.global.Utils.exception;

import com.example.demo.global.annotation.ResponseErrorCode;
import com.example.demo.global.constants.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ResponseErrorCode(ErrorCodeEnum.BAD_REQUEST)
public class BadRequestException  extends ApplicationException{
    public BadRequestException(String resource) {
        super(resource);
    }
}
