package com.github.aastrandemma.service;

import com.github.aastrandemma.model.Cryptocurrency;
import com.github.aastrandemma.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);
    Transaction createWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);
    List<Transaction> getTransactionByWalletId(String walletId);
}