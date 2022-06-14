package ax.barchuk.messaging.config

import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonSerializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import ax.barchuk.messaging.Message

@EnableKafka
@Configuration
class ProducerConfiguration {

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Message> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun producerFactory(): ProducerFactory<String, Message> {
        return DefaultKafkaProducerFactory(producerConfigurations())
    }

    @Bean
    fun producerConfigurations(): Map<String, Any> {
        return mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class, 
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class
        )
    }

}