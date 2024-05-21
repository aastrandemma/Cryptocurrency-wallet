package com.github.aastrandemma.dao;

import com.github.aastrandemma.model.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);
    Optional<Wallet> findWalletById(String id);
}