package com.github.aastrandemma.dao;

import com.github.aastrandemma.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    Transaction createTransaction(Transaction transaction);
    Optional<Transaction> findTransactionById(String transactionId);
    List<Transaction> findTransactionByWalletId(String walletId);
}