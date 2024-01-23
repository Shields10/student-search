package com.studentsearch.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String JDBC_USERNAME = "test";
    private static final String JDBC_PASSWORD = "test1234";

    private static final DataSource dataSource;

    static {
        PoolProperties p = new PoolProperties();
        p.setUrl(JDBC_URL);
        p.setDriverClassName("com.mysql.cj.jdbc.Driver");
        p.setUsername(JDBC_USERNAME);
        p.setPassword(JDBC_PASSWORD);

        dataSource = new DataSource();
        dataSource.setPoolProperties(p);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

