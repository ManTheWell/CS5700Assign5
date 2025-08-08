import kotlin.system.exitProcess

private val stateFunctions: Map<Int, (String) -> Int> = mapOf(
    -1 to { -1 },
    0 to { input -> state0(input) },
    1 to { input -> state1(input) }
)

fun isInt(input: String): Boolean {
    var state = 0

    if (input.isEmpty()) state = -1

    var index = 0

    while (index < input.length) {
        val stateFunction = stateFunctions[state] ?: { println("Unknown State: $state"); exitProcess(-1) }
        state = stateFunction(input.substring(index, index++))

        //added efficiency
        if (state == -1) break
    }

    return state != -1
}

fun state0(input: String): Int {
    return if ("123456789".contains(input[0])) 1 else -1
}

fun state1(input: String): Int {
    return if ("0123456789".contains(input[0])) 1 else -1
}

//class IsValidInt() {
//    fun isValid(input: String): Boolean {
//        if (input.isEmpty()) return false
//
//        var state = 1
//        var index = 0
//
//        while (index < input.length) {
//            when (state) {
//                -1 -> break
//                1 -> state = if (input[index].code in 49..57) 2 else -1
//                2 -> state = if (input[index].code in 48..57) 2 else -1
//            }
//            index++
//        }
//
//        return state != -1
//    }
//}
