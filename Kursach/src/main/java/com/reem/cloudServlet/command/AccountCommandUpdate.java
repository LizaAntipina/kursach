package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class AccountCommandUpdate implements Command{
    private AccountService service = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Account account = (Account) req.getSession().getAttribute("account");
        account.setName(req.getParameter("name"));
        account.setLastName(req.getParameter("lastName"));
        account.setLogin(req.getParameter("login"));
        account.setTelephone(req.getParameter("telephone"));
        account.setEmail(req.getParameter("email"));
        System.out.println(account);
        account = service.update(account);
        req.getSession().setAttribute("account",account);

        return new Page("/profile.jsp",true,"Success!");
    }
}
