package tech.owly.owly.data.grades

import java.io.Serializable


data class Grade(
    val name: String,
    val value: Int = -1
): Serializable