package com.ecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderService debitOrderService = context.getBean("debitOrderService", OrderService.class);
        OrderService creditOrderService = context.getBean("creditOrderService", OrderService.class);

        debitOrderService.placeOrder(5000.0);
        creditOrderService.placeOrder(7000.0);
    }
}