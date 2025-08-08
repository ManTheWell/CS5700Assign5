import kotlin.system.exitProcess

class IsComplexPasswordStateMachine {
    private val specialChars = listOf('!', '@', '#', '$', '%', '&', '*')

    private val stateFunctions: Map<Int, (Char) -> Int> = mapOf(
        0 to { input -> state0(input) },
        1 to { input -> state1(input) },
        2 to { input -> state2(input) },
        3 to { input -> state3(input) },
        4 to { input -> state4(input) },
    )

    fun isComplexPassword(input: String): Boolean {
        if (input.length < 8) return false

        var state = 0
        var index = 0

        while (index < input.length) {
            val stateFunction = stateFunctions[state] ?: { println("Unknown State: $state"); exitProcess(-1) }
            state = stateFunction(input[index++])

            // for added efficiency; would work without this
            if (state == -1) break
        }

        return state == 4
    }

    private fun state0(token: Char): Int {
        if (token.isUpperCase())
            return 1

        if (specialChars.contains(token))
            return 2

        return 0
    }

    private fun state1(token: Char): Int {
        if (specialChars.contains(token))
            return 3

        return 1
    }

    private fun state2(token: Char): Int {
        if (token.isUpperCase())
            return 4

        return 2
    }

    private fun state3(token: Char): Int {
        if (specialChars.contains(token))
            return 3

        return 4
    }

    private fun state4(token: Char): Int {
        if (specialChars.contains(token))
            return 3

        return 4
    }
}