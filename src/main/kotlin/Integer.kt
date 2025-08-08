import kotlin.system.exitProcess

class IsValidIntStateMachine() {
    private val stateFunctions: Map<Int, (Char) -> Int> = mapOf(
        -1 to { -1 },
        0 to { input -> state0(input) },
        1 to { input -> state1(input) }
    )

    fun isInt(input: String): Boolean {
        if (input.isEmpty()) return false

        var state = 0
        var index = 0

        while (index < input.length) {
            val stateFunction = stateFunctions[state] ?: { println("Unknown State: $state"); exitProcess(-1) }
            state = stateFunction(input[index++])

            // for added efficiency; would work without this
            if (state == -1) break
        }

        return state != -1
    }

    private fun state0(token: Char): Int {
        // when starting, must be 1 (ascii val 49) - 9 (ascii val 57)
        return if (token.code in 49..57) 1 else -1
    }

    private fun state1(token: Char): Int {
        // when already started, must be 0 (ascii val 48) - 9 (ascii val 57)
        return if (token.code in 48..57) 1 else -1
    }
}
