package MessageManagement.Model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscribeId;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID subscriberUuid;

    public Subscriber(Integer subscribeId, UUID subscriberUuid) {
        this.subscribeId = subscribeId;
        this.subscriberUuid = subscriberUuid;
    }

    public Subscriber() {

    }

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public UUID getSubscriberUuid() {
        return subscriberUuid;
    }

    public void setSubscriberUuid(UUID subscriberUuid) {
        this.subscriberUuid = subscriberUuid;
    }
}
