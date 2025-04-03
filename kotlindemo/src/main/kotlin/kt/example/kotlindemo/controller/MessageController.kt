package kt.example.kotlindemo.controller

import kt.example.kotlindemo.model.Message
import kt.example.kotlindemo.service.MessageService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/messages")
class MessageController(private val messageService: MessageService) {

    private val logger = LoggerFactory.getLogger(MessageController::class.java)

    @PostMapping
    fun addMessage(@RequestBody message: Message): Message {
        logger.info("Adding new message: ${message.content}")
        return messageService.saveMessage(message)
    }

    @GetMapping
    fun getMessages(): List<Message> {
        logger.info("Fetching all messages")
        return messageService.getAllMessages()
    }
}
