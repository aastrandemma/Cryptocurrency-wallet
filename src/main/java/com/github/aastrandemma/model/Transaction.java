package com.github.aastrandemma.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String type; //deposit, withdrawal
    private BigDecimal amount;
    private String walletId;
    private String cryptocurrencySymbol;
    private String description;
    private LocalDateTime timeStamp;

    public Transaction(String type, BigDecimal amount, String walletId, String cryptocurrencySymbol) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Amount cannot be negative.");
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.timeStamp = LocalDateTime.now();
    }

    public Transaction(String id, String type, BigDecimal amount, String walletId, String cryptocurrencySymbol, String description, LocalDateTime timeStamp) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getCryptocurrencySymbol() {
        return cryptocurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", cryptocurrencySymbol='" + cryptocurrencySymbol + '\'' +
                ", description='" + description + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}