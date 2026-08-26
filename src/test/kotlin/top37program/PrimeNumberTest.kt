package top37program

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test


class PrimeNumberTest {

    @Test
    fun `returns true for prime numbers`() {
        assertTrue(isPrime(2))
        assertTrue(isPrime(3))
        assertTrue(isPrime(7))
        assertTrue(isPrime(29))
    }

    @Test
    fun `returns false for numbers less than two`() {
        assertFalse(isPrime(-5))
        assertFalse(isPrime(0))
        assertFalse(isPrime(1))
    }

    @Test
    fun `returns false for composite numbers`() {
        assertFalse(isPrime(4))
        assertFalse(isPrime(9))
        assertFalse(isPrime(25))
        assertFalse(isPrime(100))
    }
}
