package com.github.aastrandemma;

import com.github.aastrandemma.config.AppConfig;
import com.github.aastrandemma.model.Cryptocurrency;
import com.github.aastrandemma.model.Transaction;
import com.github.aastrandemma.model.Wallet;
import com.github.aastrandemma.service.TransactionService;
import com.github.aastrandemma.service.WalletService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletService walletService = context.getBean(WalletService.class);
        TransactionService transactionService = context.getBean(TransactionService.class);

        Wallet wallet = walletService.create("my-first-wallet");
        System.out.println("----------------------------------");
        System.out.println(wallet);
        System.out.println("----------------------------------");
        System.out.println();

        Transaction depositTransactionForBTC = transactionService.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.BTC,
                new BigDecimal(10),
                "Test transaction");
        System.out.println("----------------------------------");
        System.out.println(depositTransactionForBTC);
        System.out.println("----------------------------------");
        System.out.println();

        Transaction depositTransactionForETH = transactionService.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.ETH,
                new BigDecimal(5),
                "Test transaction");
        System.out.println("----------------------------------");
        System.out.println(depositTransactionForETH);
        System.out.println("----------------------------------");
        System.out.println();
    }
}