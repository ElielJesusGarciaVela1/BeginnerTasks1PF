package _pfdemo.com.demo.controller;

import _pfdemo.com.demo.model.Message;
import _pfdemo.com.demo.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody String content) {
        Message message = messageService.addMessage(content);
        return ResponseEntity.ok(message);
    }
}
