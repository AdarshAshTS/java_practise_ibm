package com.jdbctest;

import java.io.Serializable;

public class Account implements Serializable {

    private Long id;
    private String accountHolder;
    private Double balance;

    public Account() {
    }

    public Account(Long id, String accountHolder, Double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
