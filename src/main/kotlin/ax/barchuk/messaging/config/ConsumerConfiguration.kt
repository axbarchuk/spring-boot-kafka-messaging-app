package ax.barchuk.messaging.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import ax.barchuk.messaging.Message
import ax.barchuk.messaging.KafkaProps

@Configuration
class ConsumerConfiguration() {
    
    @Bean
    fun consumerFactory(): ConsumerFactory<String, Message> {
        return DefaultKafkaConsumerFactory(mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to KafkaProps.KAFKA_BROKER,
            ConsumerConfig.GROUP_ID_CONFIG to KafkaProps.GROUP_ID,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest"
        ), StringDeserializer(), JsonDeserializer(Message::class.java))
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Message> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, Message> = ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()

        return factory
    }

}
