import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `test is_valid integer state machine`() {
        val intTester = IsValidIntStateMachine()

        assertEquals(true, intTester.isInt("1"))
        assertEquals(true, intTester.isInt("123"))
        assertEquals(true, intTester.isInt("345230352434534524046"))

        assertEquals(false, intTester.isInt(""))
        assertEquals(false, intTester.isInt("0123"))
        assertEquals(false, intTester.isInt("132a"))
        assertEquals(false, intTester.isInt("0"))
    }

    @Test
    fun `test is_valid floating point state machine`() {
        val floatingTester = IsValidFloatingPointStateMachine()

        assertEquals(true, floatingTester.isFloatingPoint("1.0"))
        assertEquals(true, floatingTester.isFloatingPoint("123.34"))
        assertEquals(true, floatingTester.isFloatingPoint("0.20000"))
        assertEquals(true, floatingTester.isFloatingPoint("12349871234.12340981234098"))
        assertEquals(true, floatingTester.isFloatingPoint(".123"))


        assertEquals(false, floatingTester.isFloatingPoint(""))
        assertEquals(false, floatingTester.isFloatingPoint("123.123."))
        assertEquals(false, floatingTester.isFloatingPoint("123.02a"))
        assertEquals(false, floatingTester.isFloatingPoint("123."))
        assertEquals(false, floatingTester.isFloatingPoint("012.4"))
    }

    @Test
    fun `test is_valid binary number state machine`() {
        val floatingTester = IsValidBinaryNumberStateMachine()

        assertEquals(true, floatingTester.isBinaryNumber("1"))
        assertEquals(true, floatingTester.isBinaryNumber("11"))
        assertEquals(true, floatingTester.isBinaryNumber("101"))
        assertEquals(true, floatingTester.isBinaryNumber("111111"))
        assertEquals(true, floatingTester.isBinaryNumber("10011010001"))

        assertEquals(false, floatingTester.isBinaryNumber("01"))
        assertEquals(false, floatingTester.isBinaryNumber("10"))
        assertEquals(false, floatingTester.isBinaryNumber("1000010"))
        assertEquals(false, floatingTester.isBinaryNumber("100a01"))
    }

    @Test
    fun `test is_valid email state machine`() {
        val floatingTester = IsValidEmailStateMachine()

        assertEquals(true, floatingTester.isValidEmail("a@b.c"))
        assertEquals(true, floatingTester.isValidEmail("joseph.ditton@usu.edu"))
        assertEquals(true, floatingTester.isValidEmail("{}*\\$.&\\$*(@*\\$%&.*&*"))

        assertEquals(false, floatingTester.isValidEmail("@b.c"))
        assertEquals(false, floatingTester.isValidEmail("a@b@c.com"))
        assertEquals(false, floatingTester.isValidEmail("a.b@b.b.c"))
        assertEquals(false, floatingTester.isValidEmail("joseph ditton@usu.edu"))
    }

    @Test
    fun `test is complex password state machine`() {
        val floatingTester = IsComplexPasswordStateMachine()

        assertEquals(true, floatingTester.isComplexPassword("aaaaH!aa"))
        assertEquals(true, floatingTester.isComplexPassword("1234567*9J"))
        assertEquals(true, floatingTester.isComplexPassword("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"))
        assertEquals(true, floatingTester.isComplexPassword("1234\\\"567* 9J"))

        assertEquals(false, floatingTester.isComplexPassword("a"))
        assertEquals(false, floatingTester.isComplexPassword("aaaaaaa!"))
        assertEquals(false, floatingTester.isComplexPassword("aaaHaaaaa"))
        assertEquals(false, floatingTester.isComplexPassword("Abbbbbbb!"))
    }
}
