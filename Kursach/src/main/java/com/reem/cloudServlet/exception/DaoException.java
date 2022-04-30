package com.reem.cloudServlet.exception;

import java.sql.SQLException;

public class DaoException extends Throwable {
    public DaoException(String message, SQLException e) {
        super(message, e);
    }
}
