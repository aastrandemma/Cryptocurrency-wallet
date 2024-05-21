package com.github.aastrandemma.service.impl;

import com.github.aastrandemma.dao.TransactionDao;
import com.github.aastrandemma.dao.WalletDao;
import com.github.aastrandemma.exception.WalletNotFoundException;
import com.github.aastrandemma.model.Cryptocurrency;
import com.github.aastrandemma.model.Transaction;
import com.github.aastrandemma.model.Wallet;
import com.github.aastrandemma.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService {
    private WalletDao walletDao;
    private TransactionDao transactionDao;

    @Autowired
    public TransactionServiceImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        if (walletId == null || cryptocurrency == null || amount == null)
            throw new IllegalArgumentException("Wallet params are not valid.");

        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if (!optionalWallet.isPresent()) throw new WalletNotFoundException("Wallet not found.");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptocurrency, amount);

        Transaction transaction = new Transaction("Deposit", amount, walletId, cryptocurrency.getName());
        transaction.setDescription(description);

        transactionDao.createTransaction(transaction);
        return transaction;
    }

    @Override
    public Transaction createWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        if (walletId == null || cryptocurrency == null || amount == null)
            throw new IllegalArgumentException("Wallet params are not valid.");

        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if (!optionalWallet.isPresent()) throw new WalletNotFoundException("Wallet not found.");

        Wallet wallet = optionalWallet.get();
        wallet.withdraw(cryptocurrency, amount);

        Transaction transaction = new Transaction("Withdraw", amount, walletId, cryptocurrency.getName());
        transaction.setDescription(description);

        transactionDao.createTransaction(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> getTransactionByWalletId(String walletId) {
        if (walletId == null) throw new IllegalArgumentException("Wallet param are not valid.");

        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if (!optionalWallet.isPresent()) throw new WalletNotFoundException("Wallet not found.");

        return transactionDao.findTransactionByWalletId(walletId);
    }
}