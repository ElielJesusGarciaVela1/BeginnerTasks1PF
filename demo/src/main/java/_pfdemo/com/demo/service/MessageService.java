package _pfdemo.com.demo.service;

import _pfdemo.com.demo.model.Message;
import _pfdemo.com.demo.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        logger.info("Fetching all messages");
        return messageRepository.findAll();
    }

    public Message addMessage(String content) {
        logger.info("Adding new message: {}", content);
        return messageRepository.save(new Message(content));
    }
}
