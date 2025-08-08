import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `test valid integers`() {
        val intTester = IsValidInt()

        assertEquals(true, intTester.isValid("1"))
        assertEquals(true, intTester.isValid("123"))
        assertEquals(true, intTester.isValid("345230352434534524046"))

        assertEquals(false, intTester.isValid(""))
        assertEquals(false, intTester.isValid("0123"))
        assertEquals(false, intTester.isValid("132a"))
        assertEquals(false, intTester.isValid("0"))
    }
}