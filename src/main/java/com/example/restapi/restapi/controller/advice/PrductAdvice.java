package com.example.restapi.restapi.controller.advice;

import com.example.restapi.restapi.DTO.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PrductAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException(NullPointerException exception) {
        MessageDTO message = new MessageDTO();
        message.setMessage(exception.getMessage());
        message.setType("ERROR");

        return message;
    }
}
