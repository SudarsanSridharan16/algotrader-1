package com.unisoft.algotrader.provider.ib.api.model.contract;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.unisoft.algotrader.provider.ib.api.model.order.ComboLeg;

import java.util.List;

/**
 * Created by alex on 9/9/15.
 */
public class Contract {

    private static final String EMPTY = "";
    private int id;
    private final List<ComboLeg> comboLegs = Lists.newArrayList();
    private String comboLegsDescription = EMPTY;
    private String currencyCode = EMPTY;
    private String exchange = EMPTY;
    private String expiry = EMPTY;
    private boolean includeExpired;
    private String localSymbol = EMPTY;
    private String multiplier = EMPTY;
    private String primaryExchange = EMPTY;
    private OptionRight optionRight = null;
    private SecurityIdentifierCode securityIdentifierCode = SecurityIdentifierCode.EMPTY;
    private String securityId = EMPTY;
    private SecType securityType = null;
    private double strike;
    private String symbol = EMPTY;
    private UnderlyingCombo underlyingCombo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ComboLeg> getComboLegs() {
        return comboLegs;
    }

    public String getComboLegsDescription() {
        return comboLegsDescription;
    }

    public void setComboLegsDescription(String comboLegsDescription) {
        this.comboLegsDescription = comboLegsDescription;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public boolean isIncludeExpired() {
        return includeExpired;
    }

    public void setIncludeExpired(boolean includeExpired) {
        this.includeExpired = includeExpired;
    }

    public String getLocalSymbol() {
        return localSymbol;
    }

    public void setLocalSymbol(String localSymbol) {
        this.localSymbol = localSymbol;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public OptionRight getOptionRight() {
        return optionRight;
    }

    public void setOptionRight(OptionRight optionRight) {
        this.optionRight = optionRight;
    }

    public SecurityIdentifierCode getSecurityIdentifierCode() {
        return securityIdentifierCode;
    }

    public void setSecurityIdentifierCode(SecurityIdentifierCode securityIdentifierCode) {
        this.securityIdentifierCode = securityIdentifierCode;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public SecType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(SecType securityType) {
        this.securityType = securityType;
    }

    public double getStrike() {
        return strike;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public UnderlyingCombo getUnderlyingCombo() {
        return underlyingCombo;
    }

    public void setUnderlyingCombo(UnderlyingCombo underlyingCombo) {
        this.underlyingCombo = underlyingCombo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return Objects.equal(id, contract.id) &&
                Objects.equal(includeExpired, contract.includeExpired) &&
                Objects.equal(strike, contract.strike) &&
                Objects.equal(comboLegs, contract.comboLegs) &&
                Objects.equal(comboLegsDescription, contract.comboLegsDescription) &&
                Objects.equal(currencyCode, contract.currencyCode) &&
                Objects.equal(exchange, contract.exchange) &&
                Objects.equal(expiry, contract.expiry) &&
                Objects.equal(localSymbol, contract.localSymbol) &&
                Objects.equal(multiplier, contract.multiplier) &&
                Objects.equal(primaryExchange, contract.primaryExchange) &&
                Objects.equal(optionRight, contract.optionRight) &&
                Objects.equal(securityIdentifierCode, contract.securityIdentifierCode) &&
                Objects.equal(securityId, contract.securityId) &&
                Objects.equal(securityType, contract.securityType) &&
                Objects.equal(symbol, contract.symbol) &&
                Objects.equal(underlyingCombo, contract.underlyingCombo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, comboLegs, comboLegsDescription, currencyCode, exchange, expiry, includeExpired, localSymbol, multiplier, primaryExchange, optionRight, securityIdentifierCode, securityId, securityType, strike, symbol, underlyingCombo);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", comboLegs=" + comboLegs +
                ", comboLegsDescription='" + comboLegsDescription + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", exchange='" + exchange + '\'' +
                ", expiry='" + expiry + '\'' +
                ", includeExpired=" + includeExpired +
                ", localSymbol='" + localSymbol + '\'' +
                ", multiplier='" + multiplier + '\'' +
                ", primaryExchange='" + primaryExchange + '\'' +
                ", optionRight=" + optionRight +
                ", securityIdentifierCode=" + securityIdentifierCode +
                ", securityId='" + securityId + '\'' +
                ", securityType=" + securityType +
                ", strike=" + strike +
                ", symbol='" + symbol + '\'' +
                ", underlyingCombo=" + underlyingCombo +
                '}';
    }
}
