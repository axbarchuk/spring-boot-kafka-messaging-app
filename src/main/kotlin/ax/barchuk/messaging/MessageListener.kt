package ax.barchuk.messaging

import org.springframework.stereotype.Component
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.kafka.annotation.KafkaListener

@Component
class MessageListener(val template: SimpMessagingTemplate) {
    @KafkaListener(
            topics = [KafkaProps.KAFKA_TOPIC],
            groupId = KafkaProps.GROUP_ID
    )
    fun listen(message: Message) {

    }
}