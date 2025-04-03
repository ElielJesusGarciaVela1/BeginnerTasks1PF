package kt.example.kotlindemo.service

import kt.example.kotlindemo.model.Message
import kt.example.kotlindemo.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun saveMessage(message: Message): Message {
        return messageRepository.save(message)
    }

    fun getAllMessages(): List<Message> {
        return messageRepository.findAll()
    }
}
