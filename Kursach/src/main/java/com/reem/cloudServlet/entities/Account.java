package com.reem.cloudServlet.entities;

import java.util.Objects;

public class Account {

    private int id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String telephone;
    private String email;
    private String status = "ACTIVE";
    private String role = "USER";


    public Account() {
    }

    public Account(int id) {
        this.id = id;
    }

    public Account(int id,
                   String name,
                   String lastName,
                   String login,
                   String telephone,
                   String email,
                   String role,
                   String status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(name, account.name) && Objects.equals(lastName, account.lastName) && Objects.equals(login, account.login) && Objects.equals(password, account.password) && Objects.equals(telephone, account.telephone) && Objects.equals(email, account.email) && Objects.equals(status, account.status) && Objects.equals(role, account.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, login, password, telephone, email, status, role);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}