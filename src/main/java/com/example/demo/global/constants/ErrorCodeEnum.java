package com.example.demo.global.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    FORBIDDEN(HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    CONFLICT(HttpStatus.CONFLICT),
    EXISTED(HttpStatus.BAD_REQUEST),
    EXPIRED(HttpStatus.BAD_REQUEST),
    URL_NOT_FOUND(HttpStatus.NOT_FOUND),
    NULL_POINTER(HttpStatus.INTERNAL_SERVER_ERROR),
    UNKNOWN_ERROR(HttpStatus.BAD_REQUEST),
    MESSAGE_NOT_READABLE(HttpStatus.BAD_REQUEST),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED),
    READ_TIME_OUT(HttpStatus.INTERNAL_SERVER_ERROR),
    UNKNOWN_HOST(HttpStatus.INTERNAL_SERVER_ERROR),
    INCORRECT_PARAMETER(HttpStatus.BAD_REQUEST),
    NOT_ALLOWED_DELETE(HttpStatus.METHOD_NOT_ALLOWED);

    private final HttpStatus httpStatus;
}
