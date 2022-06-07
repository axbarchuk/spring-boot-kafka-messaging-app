package ax.barchuk.messaging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaMessagingApplication

fun main(args: Array<String>) {
	runApplication<KafkaMessagingApplication>(*args)
}
