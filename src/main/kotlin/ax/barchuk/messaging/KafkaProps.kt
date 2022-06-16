package ax.barchuk.messaging

class KafkaProps {
    companion object {
        val KAFKA_TOPIC = "user-messages"
        val GROUP_ID = "kafka-sandbox"
        val KAFKA_BROKER = "localhost:9092"
    }
}
