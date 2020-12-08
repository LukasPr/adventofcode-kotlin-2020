package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day8-input"))
    println(determineValueOfAccumulator(readInputFile("src/main/resources/day8-input")))
}

val test = readInputFile("src/main/resources/day8-input").map { it.split(" ") }
val instructions = test.map { Pair<String, String>(it.first(), it[it.lastIndex]) }


fun determineValueOfAccumulator(input: List<String>): Int {
    var (position, accumulator, alreadyVisited) = Triple(0, 0, mutableListOf<Int>())
    while (position != instructions.lastIndex) {
        if (position in alreadyVisited) return accumulator
        val currentInstruction = instructions[position]
        alreadyVisited.add(position)
        when (currentInstruction.first) {
            "acc" -> {
                accumulator += currentInstruction.second.toInt()
                position += 1
            }
            "jmp" -> position += currentInstruction.second.toInt()
            "nop" -> position += 1
            else -> 0
        }
    }
    return accumulator
}

//unfinished....
fun swapOneOperation(input: List<String>): Int {
    var (position, accumulator, alreadyVisited) = Triple(0, 0, mutableListOf<Int>())
    var count = 0
    while (position != instructions.lastIndex) {
        count++
//        if (position in alreadyVisited) return accumulator
        val currentInstruction = instructions[position]
//        alreadyVisited.add(position)
        when (currentInstruction.first) {
            "acc" -> {
                accumulator += currentInstruction.second.toInt()
                position += 1
            }
            "jmp" -> position += currentInstruction.second.toInt()
            "nop" -> position += 1
            else -> 0
        }
    }
    return accumulator
}




