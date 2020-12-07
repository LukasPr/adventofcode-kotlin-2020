package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day7-input"))
    println(countBagsContainingShinyGold(readInputFile("src/main/resources/day7-input")))
}

//unfinished business
fun countBagsContainingShinyGold(input: List<String>): Set<Any> {
    val preparedInput = input
        .map { it.split(" bags?[.,\\s]?".toRegex()).filter { it.isNotEmpty() } }
        .map { it.map { it.replace("contain ", "").trim() }.map { it.replace(" bag", "").trim() } }

    val temporary = preparedInput
        .map { it.filterNot { it.startsWith("no") } }
        .filterNot { it.isEmpty() }

    println(temporary)

    val cleanMap = temporary.map {
        it[0] to it.drop(1).map { it.split(" ", limit = 2).let { it[1] to it[0].toInt() } }.toMap()
    }.toMap()

    return cleanMap.keys - listOf("shiny gold").count { it.equals("shiny gold") }

}




