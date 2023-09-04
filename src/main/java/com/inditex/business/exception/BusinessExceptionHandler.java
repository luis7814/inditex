package com.inditex.business.exception;

import com.inditex.business.data.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException .class)
    public @ResponseBody ErrorMessage handleNotFoundException(NotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }
}
