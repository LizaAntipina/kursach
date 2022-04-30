package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

public interface Command {
    Page execute(HttpServletRequest req) throws ServiceException, FileNotFoundException;
}
