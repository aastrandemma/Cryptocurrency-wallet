package com.github.aastrandemma.model;

public enum Cryptocurrency {
    BTC("Bitcoin"), ETH("Ethereum"), USDT("Theter USDt"), BNB("BNB");
    private final String name;

    Cryptocurrency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}