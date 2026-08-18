package com.cachingdemo.cachingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private Repository accountRepository;

    // Cache-Aside: First call hits DB, result stored in Redis
    @Cacheable(value = "accounts", key = "#accountId")
    public Account getAccountDetails(Long accountId) {
        System.out.println("Fetching from DB...");
        return accountRepository.findById(accountId).orElseThrow();
    }

    // Write-Through: Updates DB and Redis simultaneously
    @CachePut(value = "accounts", key = "#account.id")
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    // Explicit Invalidation: Removes entry from Redis when deleted
    @CacheEvict(value = "accounts", key = "#accountId")
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
