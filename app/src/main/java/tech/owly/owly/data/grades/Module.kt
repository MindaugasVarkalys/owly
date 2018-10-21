package tech.owly.owly.data.grades

import java.io.Serializable

data class Module(
    val name: String,
    val grades: List<Grade>
): Serializable {
    val average = grades.asSequence().takeWhile { it.value != -1 }.map { it.value }.average()

    val lastGrade = grades.lastOrNull { it.value > -1 }?.value
}