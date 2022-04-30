package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;

import javax.servlet.http.HttpServletRequest;

public class AccountCommandLogin implements Command {
    private final AccountService service = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        String username = req.getParameter("login");
        String password=req.getParameter("password");
        Account account = service.login(username,password);
        System.out.print(account);
        if (account == null){
            return new Page("/login.jsp",false,"password or email is wrong!!");
        }
        req.getSession().setAttribute("account",account);
        return new Page("/home.jsp",true,"Success!");
    }

}
