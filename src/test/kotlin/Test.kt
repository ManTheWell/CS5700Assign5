import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `test valid integers`() {
        val intTester = IsValidIntStateMachine()

        assertEquals(true, intTester.isInt("1"))
        assertEquals(true, intTester.isInt("123"))
        assertEquals(true, intTester.isInt("345230352434534524046"))

        assertEquals(false, intTester.isInt(""))
        assertEquals(false, intTester.isInt("0123"))
        assertEquals(false, intTester.isInt("132a"))
        assertEquals(false, intTester.isInt("0"))
    }
}