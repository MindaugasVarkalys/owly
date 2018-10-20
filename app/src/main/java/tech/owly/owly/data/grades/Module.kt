package tech.owly.owly.data.grades

data class Module(
    val name: String,
    val grades: List<Grade>
) {
    val average = grades.asSequence().map { it.value }.average()

    val lastGrade = grades.lastOrNull { it.value > -1 }?.value
}