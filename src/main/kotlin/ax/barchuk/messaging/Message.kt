package ax.barchuk.messaging

import com.fasterxml.jackson.annotation.JsonProperty

data class Message(
    val sender: String,
    val content: String,
    var timestamp: String = "",
)