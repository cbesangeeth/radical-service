package sk.radicalservice.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.radicalservice.common.Auditable;
import sk.radicalservice.common.DateTimeCustomDeserializer;
import sk.radicalservice.common.DateTimeCustomSerializer;

@Document(value = "Transactions")
public class Transaction extends Auditable<String> {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String type;
    private Long amount;
    private String description;
//    private User user;
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime transactionDate;

    public DateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(DateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
