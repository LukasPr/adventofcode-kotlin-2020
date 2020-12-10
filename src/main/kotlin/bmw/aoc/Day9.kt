package bmw.aoc

import java.math.BigInteger

fun main() {
    println(readInputFile("src/main/resources/day9-input"))
    println(findWeakNumber(readInputFile("src/main/resources/day9-input")))
}

fun findWeakNumber(input: List<String>): BigInteger {
    return input.map { it.toBigInteger() }
            .windowed(26, 1)
            .first { !it.isLastValid() } // find first occurence where the sum of 2 digits does not match the last digit
            .last()
}

fun List<BigInteger>.isLastValid(): Boolean {
    return any { currentNumber ->
        last() - currentNumber in this &&
                last() != currentNumber &&
                last() - currentNumber != currentNumber
    }
}





