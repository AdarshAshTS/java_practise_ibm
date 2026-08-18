package com.jdbctest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        CustomerDAO dao =
                context.getBean("customerDAO", CustomerDAO.class);

        System.out.println("FIRST CALL");
        dao.selectAllRows();

        System.out.println("\nSECOND CALL");
        dao.selectAllRows();
    }
}