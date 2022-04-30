package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class AccountCommandRead implements Command {
    private AccountService service = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {

        List<Account> accounts = service.readAll();
        req.getSession().setAttribute("accounts",accounts);

        return new Page("/employees.jsp", true, "Success!");

    }
}
