package com.reem.cloudServlet.service;


import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.ServiceException;
import org.junit.Test;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void readAll() throws ServiceException {
        AccountService service = new AccountService();
        List<Account> accounts = service.readAll();
        System.out.println(accounts);
    }


    @Test
    public void testReadById() throws ServiceException {
        AccountService service = new AccountService();
        Account account = service.read(1);
        System.out.println(account);
    }


    @Test
    public void deleteById() throws ServiceException {
        AccountService service = new AccountService();
        service.delete(1);
    }
}