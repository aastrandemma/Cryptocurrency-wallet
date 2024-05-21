package com.github.aastrandemma.service.impl;

import com.github.aastrandemma.dao.WalletDao;
import com.github.aastrandemma.exception.WalletNotFoundException;
import com.github.aastrandemma.exception.WalletValidationException;
import com.github.aastrandemma.model.Wallet;
import com.github.aastrandemma.service.WalletService;

import java.util.Optional;

public class WalletServiceImpl implements WalletService {
    private WalletDao walletDao;

    public WalletServiceImpl(WalletDao walletDao) {
         this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String walletName) {
        if (walletName == null) throw new WalletValidationException("Parameter is not valid.", "walletName");

        // ToDo: add more logics like: if the wallet name exists or not

        Wallet wallet = new Wallet(walletName);
        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWalletById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        throw new WalletNotFoundException("Wallet not found");
    }
}