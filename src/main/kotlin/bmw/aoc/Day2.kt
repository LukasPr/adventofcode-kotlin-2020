package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day2-input"))
    println(findNumberOfValidPasswords(readInputFile("src/main/resources/day2-input")))
    println(partTwo(readInputFile("src/main/resources/day2-input")))
}

fun findNumberOfValidPasswords(passwordPolicyWithPasswords: List<String>): Int {
    var validPwds = passwordPolicyWithPasswords.size
    val cleanList = passwordPolicyWithPasswords
        .map { it.split(" ") }
        .map { it -> it.flatMap { it.split("-") } }
        .map { it -> it.map { it.replace(":", "") } }

    for (item in cleanList) {
        val min = item[0].toInt()
        val max = item[1].toInt()
        val key = item[2].first()
        val pwd = item[3]
        val count = pwd.filter { it == key }.count()
        if (count < min || count > max) validPwds -= 1
    }
    return validPwds
}

fun partTwo(passwordPolicyWithPasswords: List<String>): Int {

    var validPwds = 0
    val cleanList = passwordPolicyWithPasswords
        .map { it.split(" ") }
        .map { it -> it.flatMap { it.split("-") } }
        .map { it -> it.map { it.replace(":", "") } }

    for (item in cleanList) {
        val positionOne = item[0].toInt()
        val positionTwo = item[1].toInt()
        val key = item[2].first()
        val pwd = item[3]

        if (pwd.length >= positionTwo) {
            if (pwd[positionOne - 1] == key && pwd[positionTwo - 1] != key) validPwds += 1
            if (pwd[positionOne - 1] != key && pwd[positionTwo - 1] == key) validPwds += 1
        }
    }
    return validPwds
}




