package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day10-input"))
    println(determineJoltDifferences())
    println(findAllArrangements())
}

val inputList = readInputFile("src/main/resources/day10-input").map { it.toInt() }.sorted()
val maxCount = inputList.maxOf { it } + 3
val finalList = (inputList + listOf(0, maxCount))
    .sorted()
    .windowed(2, 1)
val differences = finalList.map { it.last() - it.first() }

fun determineJoltDifferences(): Int {
    return differences.count { it == 1 } * differences.count { it == 3 }
}

//part 2 unfortunately not finished yet
fun findAllArrangements(): Int {
    return 0
}




