package com.reem.cloudServlet.service;

import com.reem.cloudServlet.dao.DaoAccount;
import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.DaoException;
import com.reem.cloudServlet.exception.ServiceException;

import java.util.List;


public class AccountService {
    private final DaoAccount dao = new DaoAccount();
    public Account login(String login, String password) throws ServiceException {
        try {
            return  dao.loginAccount(login,password);
        } catch (DaoException e) {
            throw new ServiceException("wrong password or username",e);
        }

    }

    public Account register(Account account) throws ServiceException{
        try {
            dao.registerAccount(account);
        }catch (DaoException e) {
            throw new ServiceException("No Account has registered",e);
        }
        return account;
    }

    public Account read(int id) throws ServiceException {
        try {
            return dao.readAccount(id);
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }

    public void delete(int id) throws ServiceException {
        try {
            dao.deleteAccountById(id);
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }

    public Account update(Account account) throws ServiceException {
        try {
            return dao.updateAccount(account);
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }
    public List<Account> readAll() throws ServiceException {
        try {
            return dao.readAllAccount();
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }

    public List<Account> readAllExpert() throws ServiceException {
        try {
            return dao.readAllExpert();
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }

    public void updateRole(int id) throws ServiceException {
        try {
            dao.updateAccountById(id);
        } catch (DaoException e) {
            throw new ServiceException("No Account exist", e);
        }
    }

}
