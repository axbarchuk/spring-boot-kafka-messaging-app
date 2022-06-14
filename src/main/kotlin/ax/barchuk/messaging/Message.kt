package ax.barchuk.messaging

data class Message(
    val sender: String,
    val content: String,
    val timestamp: String,
)