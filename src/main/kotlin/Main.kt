import java.lang.StringBuilder

fun main()
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

