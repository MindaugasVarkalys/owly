package tech.owly.owly.data.feed

open class Message(
    val firstLine: String,
    val secondLine: String,
    val thirdLine: String,
    val firstButton: String,
    val secondButton: String = ""
)