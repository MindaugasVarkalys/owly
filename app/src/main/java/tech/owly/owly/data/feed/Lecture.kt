package tech.owly.owly.data.feed

data class Lecture(
    val title: String,
    val module: String,
    val time: String,
    val room: String,
    val address: String
): Message("", "", "", "")