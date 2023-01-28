package MessageManagement.Repository;

import MessageManagement.Model.ProducerHasSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.UUID;

public interface ProducerHasSubscriberRepository extends JpaRepository<ProducerHasSubscriber, Integer> {

    @Query(value="SELECT m.messageId, m.message_content, m.dateCreated, m.producer_uuid FROM message m JOIN producer_has_subscriber ps ON ps.producer_uuid = m.producer_uuid WHERE ps.subscriber_uuid = :subscriber_uuid", nativeQuery = true)
   List<Object[]> findBySubscriberUuid(@Param("subscriber_uuid") String subscriberUuid);

    List<ProducerHasSubscriber> findByProducerUuid(UUID producerUuid);

    List<ProducerHasSubscriber> findBySubscriberUuidAndProducerUuid(UUID subscriberUuid, UUID producerUuid);

    Integer deleteBySubscriberUuidAndProducerUuid(@Param("subscriberUuid") UUID subscriberUuid, @Param("producerUuid") UUID producerUuid);

}
