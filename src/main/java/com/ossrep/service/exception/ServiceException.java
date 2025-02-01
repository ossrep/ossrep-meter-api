package com.ossrep.service.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String format, Object... args) {
        super(String.format(format, args));
    }

}
