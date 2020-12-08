package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day7-input"))
    println(cleanMap)
    println(countBagsContainingShinyGold())
    println(countPart2("shiny gold") - 1)
}

val preparedInput = readInputFile("src/main/resources/day7-input")
    .map { it.split(" bags?[.,\\s]?".toRegex()).filter { it.isNotEmpty() } }
    .map { it.map { it.replace("contain ", "").trim() }.map { it.replace(" bag", "").trim() } }

val temporary = preparedInput
    .map { it.filterNot { it.startsWith("no") } }
    .filterNot { it.isEmpty() }

val cleanMap = temporary.map {
    it[0] to it.drop(1).map { it.split(" ", limit = 2).let { it[1] to it[0].toInt() } }.toMap()
}.toMap()

fun countBagsContainingShinyGold(): Int {
    val setOfStrings = cleanMap.keys - listOf("shiny gold")
    println(setOfStrings)
    return setOfStrings.count { countStuff(it, "shiny gold") }
}

fun countStuff(stringToSearchIn: String, stringTobeSearched: String): Boolean {
    return stringToSearchIn == stringTobeSearched || cleanMap[stringToSearchIn]!!.any { (color, _) ->
        countStuff(
            color,
            stringTobeSearched
        )
    }
}

fun countPart2(masterBag: String): Int {
    return 1 + cleanMap[masterBag]!! //shiny gold={dark brown=2, mirrored coral=2, faded olive=1, posh bronze=1}
        .entries.sumBy { it.value * countPart2(it.key) } //{dark brown=2, mirrored coral=2, faded olive=1, posh bronze=1}
}






