package com.cachingdemo.cachingdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Account, Long> {
    
}
