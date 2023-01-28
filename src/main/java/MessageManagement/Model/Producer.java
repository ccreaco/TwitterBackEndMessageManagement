package MessageManagement.Model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producerId;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID producerUuid;

    public Producer(Integer producerId, UUID uuid) {
        this.producerId = producerId;
        this.producerUuid = uuid;
    }

    public Producer() {

    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public UUID getProducerUuid() {
        return producerUuid;
    }

    public void setProducerUuid(UUID uuid) {
        this.producerUuid = uuid;
    }
}
