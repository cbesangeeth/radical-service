package sk.radicalservice.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class Auditable<U> {

    @CreatedDate
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime createdAt;
    @LastModifiedDate
    @JsonSerialize(using = DateTimeCustomSerializer.class)
    @JsonDeserialize(using = DateTimeCustomDeserializer.class)
    private DateTime updatedAt;

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
