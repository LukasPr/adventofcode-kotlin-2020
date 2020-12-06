package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day3-input"))
    println(countTreesOnTheWay(readInputFile("src/main/resources/day3-input"), 3, 1))
    println(multiplyTreesOnMulipleSlopes(listOf(11, 31, 51, 71, 12), readInputFile("src/main/resources/day3-input")))
}

//fun determineNumberOfTrees(inputFile: List<String>, right: Int, down: Int): Int {
//    return inputFile.mapIndexed { column, row ->
//        Todo solve this in a functional way
//    }
//}

fun countTreesOnTheWay(lines: List<String>, right: Int, down: Int): Long {
    var (y, x, rows, columns) = arrayOf(
        0,
        0,
        lines.size,
        lines[0].length
    ) //y = actual row coordinate x = actual column coordinate
    var trees = 0L
    while (y < rows) {
        y += down //go down
        x += right // go right
        if (y >= rows)
            break
        if (lines[y][x % columns] == '#') //modulo division = if x is greater than columns start again
            trees++
    }
    return trees
}

fun multiplyTreesOnMulipleSlopes(inputOfSlopes: List<Int>, lines: List<String>): Long {
    return inputOfSlopes
        .map { countTreesOnTheWay(lines, it / 10, it % 10) }.reduce { acc, l -> acc * l }
}


