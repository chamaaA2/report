package com.ust.dynamic;


import java.math.BigDecimal;
import java.util.Comparator;

public class SLBean implements Comparable<SLBean>{

    private Long transactTime;
    private BigDecimal interestAmount;
    private BigDecimal collateralChange;
    private BigDecimal collateralAmount;
    private BigDecimal interestRate;
    private int quantity;
    private String desc ;
    private String symbol;
    private String loanId;
    private String rcc = "US";


    public SLBean(Long transactTime, BigDecimal interestAmount, BigDecimal collateralChange, BigDecimal collateralAmount, BigDecimal interestRate, int quantity, String desc, String symbol, String loanId) {
        this.transactTime = transactTime;
        this.interestAmount = interestAmount;
        this.collateralChange = collateralChange;
        this.collateralAmount = collateralAmount;
        this.interestRate = interestRate;
        this.quantity = quantity;
        this.desc = desc;
        this.symbol = symbol;
        this.loanId = loanId;
    }

    public String getRcc() {
        return rcc;
    }
    public String getLoanId() {
        return loanId;
    }

    public Long getTransactTime() {
        return transactTime;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }
    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getCollateralChange() {
        return collateralChange;
    }

    public BigDecimal getCollateralAmount() {
        return collateralAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public int compareTo(SLBean o) {
        return Comparator.comparing(SLBean::getSymbol)
            .thenComparingLong(SLBean::getTransactTime)
            .thenComparing(SLBean::getLoanId)
            .thenComparing(SLBean::getDesc)
            .compare(this, o);
    }
}
