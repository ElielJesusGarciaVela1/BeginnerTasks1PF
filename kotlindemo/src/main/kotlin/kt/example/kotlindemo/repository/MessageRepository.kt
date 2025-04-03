package kt.example.kotlindemo.repository

import kt.example.kotlindemo.model.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, Long>
