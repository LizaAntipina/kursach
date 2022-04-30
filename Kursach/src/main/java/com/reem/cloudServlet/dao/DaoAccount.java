package com.reem.cloudServlet.dao;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoAccount implements Dao {

    public void registerAccount(Account account) throws DaoException {
        String sql = "INSERT INTO Account (name, last_name, login, password,telephone,email,role,status) VALUES (?,? ,? ,?, ?, ?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, account.getName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getLogin());
            statement.setString(4, account.getPassword());
            statement.setString(5, account.getTelephone());
            statement.setString(6, account.getEmail());
            statement.setString(7, account.getRole());
            statement.setString(8, account.getStatus());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Account was registered successfully!");
            }
        } catch (SQLException e) {
            throw new DaoException("Account Existed before", e);
        }
    }

    public Account loginAccount(String login, String password) throws DaoException {
        String sql = "select * from Account where login = ? and password = ? and status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                String telephone = result.getString("telephone");
                String email = result.getString("email");
                String role = result.getString("role");
                String status = result.getString("status");
                return new Account(id, name, lastName, login,telephone, email, role, status);
            }
        } catch (SQLException e) {
            throw new DaoException("wrong username or password", e);
        }
        return null;
    }

    public List<Account> readAllExpert() throws DaoException {
        String sql = "select * from account where role='EXPERT' and status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String login = result.getString("login");
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                String telephone = result.getString("telephone");
                String email = result.getString("email");
                String role = result.getString("role");
                String status = result.getString("status");
                accounts.add(new Account(id, name, lastName, login,  telephone,  email, role, status));
            }
            return accounts;
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
    }


    public List<Account> readAllAccount() throws DaoException {
        String sql = "select * from account where role='USER' and status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String login = result.getString("login");
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                String telephone = result.getString("telephone");
                String email = result.getString("email");
                String role = result.getString("role");
                String status = result.getString("status");
                accounts.add(new Account(id,  name, lastName, login, telephone,  email, role, status));
            }
            return accounts;
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
    }


    public Account readAccount(int id) throws DaoException {
        String sql = "select * from Account where id = ? and status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                String login = result.getString("login");
                String telephone = result.getString("telephone");
                String email = result.getString("email");
                String role = result.getString("role");
                String status = result.getString("status");
               return new Account(id, name, lastName, login, telephone, email, role, status);
            }
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
        return null;
    }

    public Account updateAccount(Account account) throws DaoException {
        String sql = " UPDATE public.account SET  name=?, last_name=?, login=?,  telephone=?, email=? WHERE id = ? and status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, account.getName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getLogin());
            statement.setString(4, account.getTelephone());
            statement.setString(5, account.getEmail());
            statement.setInt(6, account.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
        return account;
    }

    public void deleteAccountById(int id) throws DaoException {
        String sql = "UPDATE Account SET status = 'DELETED' WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
    }

    public void updateAccountById(int id) throws DaoException {
        String sql = "UPDATE Account SET role = 'EXPERT' WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("No account exists", e);
        }
    }
}

