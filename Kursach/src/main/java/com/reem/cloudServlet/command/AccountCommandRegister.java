package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class AccountCommandRegister implements Command{
    private AccountService service = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Account account = new Account();

        account.setName(req.getParameter("firstname"));
        account.setLastName(req.getParameter("lastname"));
        account.setLogin(req.getParameter("login"));
        account.setPassword(req.getParameter("password"));
        account.setTelephone(req.getParameter("telephone"));
        account.setEmail(req.getParameter("email"));
        account.setStatus("ACTIVE");
        account = service.register(account);
        System.out.print(account);

        return new Page("/login.jsp",true,"Success!");
    }
}
