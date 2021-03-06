package com.paypal.bfs.test.employeeserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecordExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecordExistException(String message) {
        super(message);
    }

    public RecordExistException(String message, Throwable t) {
        super(message, t);
    }
}
