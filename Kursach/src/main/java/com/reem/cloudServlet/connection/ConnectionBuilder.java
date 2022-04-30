package com.reem.cloudServlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private static Connection connection;

    public Connection getConnection(){
        return connection;
    }

    static {
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itCompany","postgres", "1234");
            System.out.println(connection);
            System.out.println("-----------------------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

}
