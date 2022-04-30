package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class AccountCommandUpdateRole implements Command{
    private AccountService service = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {

        int id = Integer.parseInt(req.getParameter("id"));
        service.updateRole(id);
        return new Page("/home.jsp", true, "Success!");
    }
}
