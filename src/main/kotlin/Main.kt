import java.lang.StringBuilder
import java.util.Scanner
import kotlin.math.log
import kotlin.math.round
//Задание 1
/*fun main()
{
 val input = "AAADSSSRRTTHAAAA"
    val output = vhodstroki(input)
    println(output)
}

fun vhodstroki(input: String):String {
    if (input.isEmpty()) return ""
    val result = StringBuilder()
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result.append(input[i-1])
            if (count > 1) {
                result.append(count)
            }
            count = 1
        }
    }
    result.append(input[input.length - 1])
    if(count>1)
    {
        result.append(count)
    }
    return result.toString()
}


 */

// Задание 2
/*fun main()
{
    println("Введите строку")
    val input = readLine() ?: ""
    val charCount = mutableMapOf<Char, Int>()
    for (char in input)
    {
        charCount[char]=charCount.getOrDefault(char,0)+1
    }
    charCount.keys.sorted().forEach{char -> println("$char-${charCount[char]}")  }
}
*/

//Задание 3
/*fun main() {
    val scanner = Scanner(System.`in`)

    println("=== КОНВЕРТЕР ДЕСЯТИЧНЫХ ЧИСЕЛ В ДВОИЧНЫЕ ===")
    println("Введите натуральное число:")

    try {
        val decimalNumber = scanner.nextInt()

        if (decimalNumber < 0) {
            println("Ошибка: Введите натуральное число (положительное целое)!")
            return
        }

        // Преобразование в двоичную систему
        val binaryString = decimalNumber.toString(2)

        println("\nРезультат преобразования:")
        println("Десятичное: $decimalNumber")
        println("Двоичное: $binaryString")

        // Дополнительная информация


    } catch (e: Exception) {
        println("Ошибка: Введите корректное натуральное число!")
    } finally {
        scanner.close()
    }
}
*/
//Задание 4
/*fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите выражение в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    println("Доступные операции: +, -, *, /")
    print("Ввод: ")

    try {
        val input = scanner.nextLine().trim()
        val parts = input.split(" ")

        if (parts.size != 3) {
            throw IllegalArgumentException("Неверный формат ввода. Используйте: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
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
                    throw ArithmeticException("Ошибка: деление на ноль!")
                }
                number1 / number2
            }
            else -> throw IllegalArgumentException("Неизвестная операция: $operation. Доступные: +, -, *, /")
        }

        println("Результат: $result")

    } catch (e: NumberFormatException) {
        println("Ошибка: введены некорректные числа!")
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    } catch (e: ArithmeticException) {
        println(e.message)
    } catch (e: Exception) {
        println("Произошла неизвестная ошибка: ${e.message}")
    }
}

 */
//Задание 5
/*fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод данных от пользователя
    print("Введите целое число n: ")
    val n = scanner.nextInt()

    print("Введите основание степени x: ")
    val x = scanner.nextInt()

    // Проверка на особые случаи
    if (x == 1) {
        if (n == 1) {
            println("y = 0 (любое число)")
        } else {
            println("Целочисленный показатель не существует")
        }
        return
    }

    if (x == -1) {
        if (n == 1 || n == -1) {
            println("y существует (четный для 1, нечетный для -1)")
        } else {
            println("Целочисленный показатель не существует")
        }
        return
    }

    if (n == 1) {
        println("y = 0")
        return
    }

    if (n == 0) {
        if (x == 0) {
            println("y > 0")
        } else {
            println("Целочисленный показатель не существует (0 в любой ненулевой степени дает 0)")
        }
        return
    }

    // Основной алгоритм
    val y = findExponent(n, x)

    if (y != null) {
        println("y = $y")
        // Проверка
        println("Проверка: $x^$y = ${Math.pow(x.toDouble(), y.toDouble()).toInt()}")
    } else {
        println("Целочисленный показатель не существует")
    }
}

fun findExponent(n: Int, x: Int): Int? {
    // Для положительных оснований
    if (x > 0) {
        return findPositiveExponent(n, x)
    }
    // Для отрицательных оснований
    else {
        return findNegativeExponent(n, x)
    }
}

fun findPositiveExponent(n: Int, x: Int): Int? {
    // Используем логарифм для приблизительного определения показателя
    val approximateY = log(n.toDouble(), x.toDouble())
    val candidate1 = approximateY.toInt()
    val candidate2 = candidate1 + 1

    // Проверяем ближайшие целые значения
    for (candidate in listOf(candidate1, candidate2)) {
        if (candidate >= 0 && Math.pow(x.toDouble(), candidate.toDouble()).toInt() == n) {
            return candidate
        }
    }

    return null
}

fun findNegativeExponent(n: Int, x: Int): Int? {
    // Для отрицательных оснований проверяем только нечетные степени
    // (четные степени дадут положительный результат)

    var y = 1
    var result = x

    // Ограничим максимальное значение для избежания бесконечного цикла
    val maxIterations = 1000

    while (y <= maxIterations) {
        if (result == n) {
            return y
        }

        // Умножаем на основание, но следим за переполнением
        val nextResult = result * x
        if (nextResult / x != result) { // Проверка на переполнение
            break
        }
        result = nextResult
        y++
    }

    return null
}

// Альтернативная версия с перебором (более надежная для небольших чисел)
fun findExponentByBruteForce(n: Int, x: Int): Int? {
    if (x == 0) return null
    if (n == 1) return 0

    var result = 1
    var y = 0

    while (true) {
        y++
        result *= x

        if (result == n) {
            return y
        }

        // Условия выхода из цикла
        if (Math.abs(result) > Math.abs(n) * 2) break // Результат значительно превысил n
        if (y > 1000) break // Защита от бесконечного цикла
        if (x > 0 && result > n && n > 0) break // Для положительных чисел - превысили целевое значение
        if (x > 1 && result < n && n < 0) break // Для отрицательных результатов
    }

    return null
}
*/

//Задание 6
fun main() {
    // Ввод первой цифры
    println("Введите первую цифру:")
    val firstDigit = readln().toIntOrNull()

    // Ввод второй цифры
    println("Введите вторую цифру:")
    val secondDigit = readln().toIntOrNull()

    // Проверка корректности ввода
    if (firstDigit == null || secondDigit == null) {
        println("Ошибка: необходимо ввести цифры (0-9)")
        return
    }

    if (firstDigit !in 0..9 || secondDigit !in 0..9) {
        println("Ошибка: введены не цифры (0-9)")
        return
    }

    if (firstDigit == secondDigit) {
        println("Ошибка: цифры должны быть различными")
        return
    }

    // Попытка создать нечетное число
    val result = findOddNumber(firstDigit, secondDigit)

    // Вывод результата
    if (result != null) {
        println("Результат: $result")
    } else {
        println("Создать нечетное число невозможно")
    }
}

fun findOddNumber(digit1: Int, digit2: Int): Int? {
    // Пробуем составить число из двух цифр
    val number1 = digit1 * 10 + digit2
    val number2 = digit2 * 10 + digit1

    // Проверяем, является ли какое-то из чисел нечетным
    if (number1 % 2 != 0) {
        return number1
    }
    if (number2 % 2 != 0) {
        return number2
    }

    // Если оба числа четные
    return null
}