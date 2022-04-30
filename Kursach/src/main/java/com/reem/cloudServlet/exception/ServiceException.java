package com.reem.cloudServlet.exception;
public class ServiceException extends Throwable {
    public ServiceException(String message, DaoException e) {
        super(message, e);
    }

    public ServiceException(String error_during_pasing_) {
    }
}
