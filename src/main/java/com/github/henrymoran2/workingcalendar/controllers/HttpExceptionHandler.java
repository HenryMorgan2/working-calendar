package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.dto.ResponceDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@ResponseBody
@Data
public class HttpExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponceDTO handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {

        return new ResponceDTO("Отсутствует обязательный параметр запроса: " + exception.getParameterName()
                + ". Параметр должен иметь тип: " + exception.getParameterType(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponceDTO handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {

        return new ResponceDTO("Не правильный тип параметра запроса: " + exception.getName()
                + ". Параметр должен иметь тип: LocalDate", HttpStatus.BAD_REQUEST.value());
    }


}
