package com.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

public class CustomerDAO {

    private String driver;
    private String url;
    private String userName;
    private String password;

    // Setter methods for dependency injection
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Cacheable("customers")
    public List<String> selectAllRows() throws ClassNotFoundException, SQLException {

        System.out.println("Fetching customer data from DATABASE...");

        Class.forName(driver);

        List<String> customers = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, userName, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customer")) {

            while (rs.next()) {

                long id = rs.getLong("id");
                String accountType = rs.getString("account_type");

                customers.add(
                    "ID: " + id +
                    ", Account Type: " + accountType
                );
            }
        }

        return customers;
    }
}