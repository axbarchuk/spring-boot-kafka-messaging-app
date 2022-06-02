package ax.barchuk.messaging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKafkaMessagingAppApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKafkaMessagingAppApplication>(*args)
}
