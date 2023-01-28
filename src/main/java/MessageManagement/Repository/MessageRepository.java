package MessageManagement.Repository;

import MessageManagement.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByProducerUuid(UUID producerUuid);

}
