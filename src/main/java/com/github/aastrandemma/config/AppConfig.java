package com.github.aastrandemma.config;

import com.github.aastrandemma.dao.impl.TransactionDaoImpl;
import com.github.aastrandemma.dao.impl.WalletDaoImpl;
import com.github.aastrandemma.service.impl.TransactionServiceImpl;
import com.github.aastrandemma.service.impl.WalletServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.github.aastrandemma")
public class AppConfig {
    /*@Bean
    public TransactionDaoImpl transactionDao() {
        return new TransactionDaoImpl();
    }

    @Bean
    public WalletDaoImpl walletDao() {
        return new WalletDaoImpl();
    }

    @Bean
    public TransactionServiceImpl transactionService() {
        return new TransactionServiceImpl(walletDao(), transactionDao());
    }

    @Bean
    public WalletServiceImpl walletService() {
        return new WalletServiceImpl(walletDao());
    }*/
}