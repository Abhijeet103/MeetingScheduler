package com.meeting.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIntervalException extends RuntimeException{
    public InvalidIntervalException(String message)
    {

        super(message);
    }
}
