package com.github.aastrandemma.dao.impl;

import com.github.aastrandemma.dao.WalletDao;
import com.github.aastrandemma.model.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WalletDaoImpl implements WalletDao {
    private List<Wallet> storage;

    public WalletDaoImpl() {
        System.out.println("Wallet list is initialized and ready to use.");
        this.storage = new ArrayList<>();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        storage.add(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findWalletById(String id) {
        return storage.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst();
    }
}