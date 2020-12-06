package bmw.aoc

fun main() {
    println(readInputFile("src/main/resources/day4-input"))
    println("Valid passports: " + countValidPassportsPartOne(readInputFile("src/main/resources/day4-input")))
    println("Valid passports with constraints: " + countValidPassportsPartTwo(readInputFile("src/main/resources/day4-input")))
}

val necessaryFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun countValidPassportsPartOne(passports: List<String>): Int = passports
    .joinToString(" ")
    .split("  ")
    .count { necessaryFields.fold(true) { bool, passport -> it.contains(passport) && bool } }

fun countValidPassportsPartTwo(passports: List<String>): Int = passports
    .joinToString(" ")
    .split("  ")
    .count { constraints.fold(true) { bool, constraint -> bool && it.contains(constraint) } }

val constraints = listOf(
    "(byr:19[2-9][0-9])|(byr:200[0-2])".toRegex(),
    "(iyr:201[0-9])|(iyr:2020)".toRegex(),
    "(eyr:202[0-9])|(eyr:2030)".toRegex(),
    "(hgt:(1[5-8][0-9]|19[0-3])cm)|(hgt:[5-6][0-9]in)|(hgt:7[0-6]in)".toRegex(),
    "hcl:#[a-f0-9]{6}".toRegex(),
    "(ecl:amb|blu|brn|gry|grn|hzl|oth)".toRegex(),
    "pid:[0-9]{9}(?=\\s|\$)".toRegex()
)

//(?=\s|$) = positive lookahead on the immediately following 9 digits
//matches any whitespace (\s) or asserts position at the end of line ($)
//pid:[0-9]{9} would match pid:8261494508 although it is too long
//pid:[0-9]{9}(?=\s|$) takes a look at the 10th digit and determines that it is not a whitespace nor a end of line