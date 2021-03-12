package com.paypal.bfs.test.employeeserv.exception;

public class InvalidRequestParam extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidRequestParam(String message) {
        super(message);
    }

    public InvalidRequestParam(String message, Throwable t) {
        super(message, t);
    }
}
