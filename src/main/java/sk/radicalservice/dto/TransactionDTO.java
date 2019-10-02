package sk.radicalservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import sk.radicalservice.common.DateTimeCustomDeserializer;
import sk.radicalservice.common.DateTimeCustomSerializer;
import sk.radicalservice.domain.Transaction;

public class TransactionDTO {

    private String id;
    private String type;
    private String description;
    private Long amount;
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime transactionDate;
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime createdAt;
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime updateAt;

    public TransactionDTO(){

    }
    public TransactionDTO(Transaction transaction) {
        this.description = transaction.getDescription();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.id = transaction.getId();
        this.createdAt = transaction.getCreatedAt();
        this.updateAt = transaction.getUpdatedAt();
        this.transactionDate = transaction.getTransactionDate();
    }

    public Transaction convertToEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setType(this.type);
        transaction.setDescription(this.description);
        transaction.setAmount(this.amount);
        transaction.setTransactionDate(this.transactionDate);

        return transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public DateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(DateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(DateTime updateAt) {
        this.updateAt = updateAt;
    }
}

