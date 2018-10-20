package tech.owly.owly.data

open class Message(
    val firstLine: String,
    val secondLine: String,
    val thirdLine: String,
    val firstButton: String,
    val secondButton: String = ""
)