package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day5-input"))
    println("Highest seat ID: " + findHighestSeatId(readInputFile("src/main/resources/day5-input")))
    println("ID of my seat: " + part2(readInputFile("src/main/resources/day5-input")))
}

fun findHighestSeatId(input: List<String>): Int = input
    .map { s ->
        s.map { if (it == 'F' || it == 'L') '0' else '1' }
            .joinToString("")
            .toInt(2)
    }.maxOf { it }

fun part2(input: List<String>): Int = input
    .map { s ->
        s.map { if (it == 'F' || it == 'L') '0' else '1' }
            .joinToString("")
            .toInt(2)
    }
    .sorted()
    .zipWithNext()
    .first { (a, b) -> a + 1 != b }
    .let { (a, _) -> a + 1 }





