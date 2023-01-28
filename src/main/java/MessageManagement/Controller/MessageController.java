package MessageManagement.Controller;

import MessageManagement.Model.ProducerHasSubscriber;
import MessageManagement.Repository.SubscriberRepository;
import MessageManagement.Model.Message;
import MessageManagement.Repository.MessageRepository;
import MessageManagement.Repository.ProducerHasSubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    ProducerHasSubscriberRepository producerHasSubscriberRepository;

    @GetMapping(path = "/messages")
    public List<Message> getAllMessages()  {

        return messageRepository.findAll();
    }

    @PostMapping(path = "/messages/new", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Message createNewMessage(@RequestBody Message message) {

        Message newMessage = new Message ();

        newMessage.setMessageContent(message.getMessageContent());
        newMessage.setDateCreated(message.getDateCreated());
        newMessage.setProducerId(message.getProducerId());


        return messageRepository.save(newMessage);

    }

    @GetMapping(path ="/messages/delete/{id}")
    public boolean deleteMessage(Integer messageId) {
        if(!messageRepository.findById(messageId).equals(Optional.empty())) {
            messageRepository.deleteById(messageId);
            return true;
        }
        return false;
    }

    @GetMapping(path = "/messages/{producerUuid}")
    public List<Message> getMessageByUUID(@PathVariable UUID producerUuid) {

        return messageRepository.findByProducerUuid(producerUuid);

    }

    @GetMapping(path = "/messages/producer/subscribers/{producerUuid}")
    public List<ProducerHasSubscriber> getProducerSubscribers(@PathVariable UUID producerUuid) {
        return producerHasSubscriberRepository.findByProducerUuid(producerUuid);
    }


  @GetMapping(path = "/messages/subscribers/{subscriberUuid}")
   public List<Object[]> getMessagesBySubscriber(@PathVariable("subscriberUuid") String subscriberUuid) {
       return producerHasSubscriberRepository.findBySubscriberUuid(subscriberUuid);
   }

   @PostMapping(path = "/messages/newsubscription")
    public ProducerHasSubscriber newSubscription(@RequestBody ProducerHasSubscriber producerHasSubscriber) {
        ProducerHasSubscriber ps = new ProducerHasSubscriber();

        ps.setProducerUuid(producerHasSubscriber.getProducerUuid());
        ps.setSubscriberUuid(producerHasSubscriber.getSubscriberUuid());

        return producerHasSubscriberRepository.save(ps);
   }

   @DeleteMapping(path ="/messages/delete-subscription/{subscriberUuid}/{producerUuid}")
   @Transactional
    public Integer deleteSubscription(@PathVariable UUID subscriberUuid, @PathVariable UUID producerUuid) {
       if(!producerHasSubscriberRepository.findBySubscriberUuidAndProducerUuid(subscriberUuid, producerUuid).equals(Optional.empty())) {
           producerHasSubscriberRepository.deleteBySubscriberUuidAndProducerUuid(subscriberUuid, producerUuid);

           return 1;
       }
        return 0;
   }
}
