package com.reem.cloudServlet.controller;
import com.reem.cloudServlet.command.Command;
import com.reem.cloudServlet.command.CommandFactory;
import com.reem.cloudServlet.command.Page;
import com.reem.cloudServlet.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class MainController  extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(req);
        try {
            Page page = command.execute(req);
            if (page.isRedirect()) {
                redirect(page.getUrl(), req, resp);
            } else {
                forward(page.getUrl(), req, resp);
            }
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    private void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }

    private void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }
}