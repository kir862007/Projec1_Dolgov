import kotlin.math.abs
import kotlin.math.log
import kotlin.math.round

fun main() {

    println("Hello World!")
    while(true){

        println("Choose the application (1-6)")
        val input = readLine()
        val value = input?.toIntOrNull()
        println()

        when (value) {
            1 -> {
                println("Enter any string")

                val input = readLine()!!
                println(task1(input))
            }

            2 -> {
                println("Enter any string")

                val input = readln()
                println(task2(input))
            }

            3 -> {

                println(task3())

            }

            4 -> {

                println(task4())

            }

            5 -> {

                println(task5())

            }

            6 -> {

                println(task6())

            }

            else -> {
                println("Wrong exit")
                break;
            }

        }
        println();
    }

}

fun task1(input: String): String {
    if (input.isEmpty()) return "the stack is empty"

    var currentChar = input[0]
    var count = 1
    val result = StringBuilder()

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            count++
        } else {
            result.append(currentChar)
            if (count > 1) result.append(count)
            currentChar = input[i]
            count = 1
        }
    }

    result.append(currentChar)
    if (count > 1) result.append(count)

    return result.toString()
}
fun task2(input: String) {
    val charCount = mutableMapOf<Char, Int>()

    for (char in input) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    val sortedKeys = charCount.keys.sorted()

    for (key in sortedKeys) {
        println("$key - ${charCount[key]}")
    }
}

fun task3() {

    println("Convert to binary")

    print("Enter an integer: ")
    val input = readLine()?.toIntOrNull()

    if (input != null && input >= 0) {
        val binary = input.toString(2)
        println("result: $binary")
    } else {
        println("Error: integer is excepted")
    }
}

fun task4() {

    println("Enter two number and math symbol (as 5.2 3.1 +)")

    val input = readLine()?.trim()

    if (input.isNullOrEmpty()) {
        println("Empty input")
        return
    }

    val parts = input.split(" ")

    if (parts.size != 3) {
        println("Wrong input")
        return
    }

    val number1 = parts[0].toDouble()
    val number2 = parts[1].toDouble()
    val operation = parts[2]

    val result = when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> {
            if (number2 == 0.0) {
                println("Error: /0")
                return
            }
            number1 / number2
        }
        else -> {
            println("Acceptable symbol: +, -, *, /")
            return
        }
    }


    println("Result: $result")

    return
}

fun task5() {

    println("Enter an integer:")
    val n = readLine()?.toIntOrNull()

    println("Enter the degree basis:")
    val x = readLine()?.toIntOrNull()

    if (n == null || x == null ||x <= 0 || x == 1 || n <= 0) {
        println("An Integer degree indicator is not exist")
        return
    }

    val yDouble = log(n.toDouble(), x.toDouble())

    val yRounded = round(yDouble).toInt()

    if (abs(yDouble - yRounded) < 1e-10) {
        var result = 1L
        for (i in 0 until yRounded) {
            result *= x
            if (result > n) break
        }

        if (result == n.toLong()) {
            println("An Integer degree indicator is exist: y = $yRounded")
            println("Checking: $x^$yRounded = ${result}")
        } else {
            println("An Integer degree indicator is not exist")
        }
    } else {
        println("An Integer degree indicator is not exist")
    }
}

fun task6() {

    println("Enter first number (0-9):")
    val num1 = readln().toInt()

    println("Enter second number (0-9):")
    val num2 = readln().toInt()

    if (num1 == num2) {
        println("Numbers must be different")
        return
    }

    if (num1 !in 0..9 || num2 !in 0..9) {
        println("Numbers must be in range 0 - 9")
        return
    }

    val numbers = listOf(num1 * 10 + num2, num2 * 10 + num1)
    val oddNumber = numbers.firstOrNull { it % 2 != 0 }

    if (oddNumber != null) {
        println("odd number: $oddNumber")
    } else {
        println("Its unreal to make the odd number")
    }
}
