package bmw.aoc

fun main(args: Array<String>) {
    println("Solution Part 1: " + chooseNumbersTwoEntries(readInputFile("src/main/resources/day1-input")))
    println("Solution Part 2: " + chooseNumbersThreeEntries(readInputFile("src/main/resources/day1-input")))
}

fun chooseNumbersTwoEntries(listOfAllNumbers: List<String>): Int {
    val inputList = listOfAllNumbers.map { it.toInt() }
    return inputList
        .flatMap { i
            -> inputList.map { j -> Pair(i, j) } }
        .first { it.first + it.second == 2020 }
        .let { it.first * it.second }
}

fun chooseNumbersThreeEntries(listOfAllNumbers: List<String>): Int {
    val inputList = listOfAllNumbers.map { it.toInt() }
    return inputList
        .flatMap { i -> inputList.flatMap { j -> inputList.map { k -> Triple(i, j, k) } } }
        .first { it.first + it.second + it.third == 2020 }
        .let { it.first * it.second * it.third}
}

//fun readInputFile(fileName: String): List<String> = File(fileName).readLines()
