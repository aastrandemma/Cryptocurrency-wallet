package com.github.aastrandemma.service;

import com.github.aastrandemma.model.Wallet;

public interface WalletService {
    Wallet create(String walletName);
    Wallet getById(String id);
}