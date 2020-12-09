package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day8-input"))
    println(determineValueOfAccumulator())
    println(swapOneOperation())
}

val instructions = readInputFile("src/main/resources/day8-input")
    .map { it.split(" ") }
    .map { Pair<String, String>(it.first(), it[it.lastIndex]) }

//part1
fun determineValueOfAccumulator(): Int {
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

//part2
fun swapOneOperation(): Int {
    val copyOfInstructions = instructions.toMutableList()
    var result = 0
    instructions.forEachIndexed { index, pair ->
        when (pair.first) {
            "jmp" -> copyOfInstructions[index] = copyOfInstructions[index].copy(first = "nop")
            "nop" -> copyOfInstructions[index] = copyOfInstructions[index].copy(first = "jmp")
            else -> 0
        }
        if (determineValueOfAccumulatorForPartTwo(copyOfInstructions) != -1) {
            result = determineValueOfAccumulatorForPartTwo(copyOfInstructions)
            return result
        } else {
            pair.copy(first = pair.first)
            copyOfInstructions[index] = copyOfInstructions[index].copy(first = pair.first)
        }
    }
    return 0
}

//part2
fun determineValueOfAccumulatorForPartTwo(input: List<Pair<String, String>>): Int {
    var (position, accumulator, alreadyVisited) = Triple(0, 0, mutableListOf<Int>())
    while (position != input.lastIndex) {
        if (position in alreadyVisited) return -1
        val currentInstruction = input[position]
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



