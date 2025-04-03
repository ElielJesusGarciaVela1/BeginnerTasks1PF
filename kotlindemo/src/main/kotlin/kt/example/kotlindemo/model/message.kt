package kt.example.kotlindemo.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
data class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,  // Auto-generated ID

    val content: String
)
