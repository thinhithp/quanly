package com.example.demo.global.annotation;



import com.example.demo.global.constants.ErrorCodeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ResponseErrorCode {
    ErrorCodeEnum value();
}
