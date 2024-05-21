package com.github.aastrandemma.model;

import com.github.aastrandemma.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Wallet {
    private final String id;
    private final String walletName;
    private Map<Cryptocurrency, BigDecimal> cryptocurrencies;

    public Wallet(String walletName) {
        this.id = UUID.randomUUID().toString();
        this.walletName = walletName;
        cryptocurrencies = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getWalletName() {
        return walletName;
    }

    public Map<Cryptocurrency, BigDecimal> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public void deposit(Cryptocurrency cryptocurrency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Deposit must be grater than zero.");
        BigDecimal currentBalance = getBalance(cryptocurrency);
        BigDecimal newBalance = currentBalance.add(amount);
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    public void withdraw(Cryptocurrency cryptocurrency, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdrawal must be grater than zero.");
        BigDecimal currentBalance = getBalance(cryptocurrency);
        if (currentBalance.compareTo(amount) <= 0)
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        BigDecimal newBalance = currentBalance.subtract(amount);
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    public BigDecimal getBalance(Cryptocurrency cryptocurrency) {
        return cryptocurrencies.getOrDefault(cryptocurrency, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", walletName='" + walletName + '\'' +
                ", cryptocurrencies=" + cryptocurrencies +
                '}';
    }
}