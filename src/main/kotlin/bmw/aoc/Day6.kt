package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day6-input"))
    println("Sum anybody answered \"yes\": " + findSumOfYesAnswers(readInputFile("src/main/resources/day6-input")))
    println("Sum everyone answered \"yes\": " + findSumEveryoneYes(readInputFile("src/main/resources/day6-input")))
}

fun findSumOfYesAnswers(input: List<String>): Int = input.joinToString(" ")
    .split("  ")
    .map { it.replace(" ", "").toSet().size }
    .sum()

fun findSumEveryoneYes(input: List<String>): Int = input.joinToString(" ")
    .split("  ")
    .map { it.split(" ").map(String::toSet) }
    .map { it.reduce { acc, set -> acc.intersect(set) } }
    .sumBy { it.size }





