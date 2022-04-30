package com.reem.cloudServlet.dao;

import java.sql.Connection;
import com.reem.cloudServlet.connection.ConnectionBuilder;
public interface Dao {
    Connection connection = new ConnectionBuilder().getConnection();
}
