package com.mockitotest;

public interface BankRepository {
   BankAccount findByAccountNumber(String accountNumber);
   void save(BankAccount account);
}
