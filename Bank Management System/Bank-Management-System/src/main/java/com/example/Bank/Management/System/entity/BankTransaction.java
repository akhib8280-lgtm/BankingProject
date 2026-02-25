package com.example.Bank.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "BANK_TRANSACTION")
@SequenceGenerator(
        name = "bank_txn_seq_gen",
        sequenceName = "BANK_TXN_SEQ",
        allocationSize = 1
)
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_txn_seq_gen")
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "TRANSACTION_TYPE", nullable = false, length = 20)
    private String transactionType;

    @Column(name = "AMOUNT", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    // Many Transactions -> One Account (Owning Side)
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @JsonBackReference
    private BankAccount account;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    // Getters and Setters
}
