package MessageManagement.Model;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private String messageContent;
    private Date dateCreated;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID producerUuid;


    public Message(String messageContent, Date dateCreated, UUID producerUuid) {
        this.messageContent = messageContent;
        this.dateCreated = dateCreated;
        this.producerUuid = producerUuid;
    }

    public Message() {

    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UUID getProducerId() {
        return producerUuid;
    }

    public void setProducerId(UUID producerUuid) {
        this.producerUuid = producerUuid;
    }
}
