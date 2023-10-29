package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.dto.ResponceDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Data
public class HttpExceptionHandler {

    @ExceptionHandler
    public ResponceDTO handleMissingServletRequestParameterException(MissingServletRequestParameterException exception){

        return new ResponceDTO("Отсутствует обязательный параметр запроса: " + exception.getParameterName()
                + ". Параметр должен иметь тип: " + exception.getParameterType(), HttpStatus.BAD_REQUEST.value());
    }
}
