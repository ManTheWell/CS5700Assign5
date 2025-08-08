import kotlin.system.exitProcess

class IsValidBinaryNumberStateMachine {
    private val stateFunctions: Map<Int, (Char) -> Int> = mapOf(
        -1 to { -1 },
        0 to { input -> state0(input) },
        1 to { input -> state1(input) },
        2 to { input -> state2(input) },
    )

    fun isBinaryNumber(input: String): Boolean {
        if (input.isEmpty()) return false

        var state = 0
        var index = 0

        while (index < input.length) {
            val stateFunction = stateFunctions[state] ?: { println("Unknown State: $state"); exitProcess(-1) }
            state = stateFunction(input[index++])

            // for added efficiency; would work without this
            if (state == -1) break
        }

        return state != -1 && state != 2
    }

    private fun state0(token: Char): Int {
        if (token == '1')
            return 1

        return -1
    }

    private fun state1(token: Char): Int {
        if (token == '1')
            return 1

        if (token == '0')
            return 2

        return -1
    }

    private fun state2(token: Char): Int {
        if (token == '1')
            return 1

        if (token == '0')
            return 2

        return -1
    }
}