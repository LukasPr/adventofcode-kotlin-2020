package bmw.aoc

import java.math.BigInteger

fun main() {
//    println(readInputFile("src/main/resources/day9-input"))
//    println(findWeakNumber(readInputFile("src/main/resources/day9-input")))
    println(findEncryptionWeakness(readInputFile("src/main/resources/day9-input")))
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

fun findEncryptionWeakness(input: List<String>): BigInteger {
    val targetNumber = findWeakNumber(input)
    val data = input.map { it.toBigInteger() }

    var index = 0
    var sizeOfDigitsToSum = 2
    var sum = 0.toBigInteger()

    while (sum != targetNumber) {
        if (index + sizeOfDigitsToSum > data.lastIndex) break
        sum = data.subList(index, index + sizeOfDigitsToSum).sumOf { it }
        sizeOfDigitsToSum++
        if (sum > targetNumber || index + sizeOfDigitsToSum > data.lastIndex) {
            index++
            sizeOfDigitsToSum = 2
        }
    }
    return data.subList(index, index + sizeOfDigitsToSum)
        .sorted()
        .let { it.first() + it.last() }
}







