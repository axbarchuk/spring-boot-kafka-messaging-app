package ax.barchuk.messaging

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.kafka.core.KafkaTemplate
import java.time.LocalDateTime

@RestController
@RequestMapping("/messsages")
class ChatController(val kafkaTemplate: KafkaTemplate<String, Message>) {


    // @PostMapping("/send")
    // fun sendMessage(@RequestBody message: Message) {
    //     message.timestamp = LocalDateTime.now().toString()
    //     try {
    //         //Sending the message to kafka topic queue
    //         kafkaTemplate.send(KafkaProps.KAFKA_TOPIC, message).get()
    //     } catch () {
            
    //     }
    // }
    
}