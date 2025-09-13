import java.lang.StringBuilder

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
