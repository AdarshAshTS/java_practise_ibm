package com.welcome;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Welcome message = context.getBean("welcomeMessage", Welcome.class);
        message.welcomePrint();

        Students student = context.getBean("student", Students.class);
        student.getName();
    }
}
