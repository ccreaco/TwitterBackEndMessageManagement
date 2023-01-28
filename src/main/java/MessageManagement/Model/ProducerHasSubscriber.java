package MessageManagement.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "producer_has_subscriber")
public class ProducerHasSubscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID producerUuid;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID subscriberUuid;

    public ProducerHasSubscriber(UUID producerUuid, UUID subscriberUuid) {
        this.producerUuid = producerUuid;
        this.subscriberUuid = subscriberUuid;
    }

    public ProducerHasSubscriber() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getProducerUuid() {
        return producerUuid;
    }

    public void setProducerUuid(UUID producerUuid) {
        this.producerUuid = producerUuid;
    }

    public UUID getSubscriberUuid() {
        return subscriberUuid;
    }

    public void setSubscriberUuid(UUID subscriberUuid) {
        this.subscriberUuid = subscriberUuid;
    }
}
