package com.nickperov.hello_pit_test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    /**
     * This test gives 100 percent covearag, but does not have any assertions and checks nothing.
     */
    @SuppressWarnings({"All"})
    @Test
    void testProduct_onesNoAssertion() {
        calculator.product(1, 1);
    }

    /**
     * This test checks very specific case. 
     */
    @Test
    void testProduct_onesCheckResult() {
        Assertions.assertEquals(1, calculator.product(1, 1));
    }

    /**
     * Another specific case, but mutation testing gives green light. 
     */
    @Test
    void testProduct_zerosCheckResult() {
        Assertions.assertEquals(0, calculator.product(0, 0));
    }

    @Test
    void testProduct_fZeroRoundingUp() {
        Assertions.assertEquals(0, calculator.product(0, 5, true));
    }

    @Test
    void testProduct_sZeroRoundingUp() {
        Assertions.assertEquals(0, calculator.product(10, 0, true));
    }

    @Test
    void testProduct_zerosRoundingUp() {
        Assertions.assertEquals(0, calculator.product(0, 0, true));
    }

    @Test
    void testProduct_zerosRoundingDown() {
        Assertions.assertEquals(0, calculator.product(0, 0, false));
    }

    @Test
    void testProduct_RandomRoundingUp() {
        Assertions.assertEquals(29, calculator.product(10.33, 2.78, true));
    }

    @Test
    void testProduct_RandomRoundingDown() {
        Assertions.assertEquals(28, calculator.product(10.33, 2.78, false));
    }

    @Test
    void testProductLimited_zeros() {
        Assertions.assertEquals(0, calculator.productLimited(0, 0));
    }

    @Test
    void testProductLimited_largePositiveNumberFirst() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.productLimited(234098, 0));
    }

    @Test
    void testProductLimited_largeNegativeNumberFirst() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.productLimited(-1245904, 0));
    }

    @Test
    void testProductLimited_largePositiveNumberSecond() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.productLimited(10, 5478992));
    }

    @Test
    void testProductLimited_largeNegativeNumberSecond() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.productLimited(10, -879245));
    }

    @Test
    void testProductLimited_testBoundary() {
        Assertions.assertEquals(200000, calculator.productLimited(100000, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.productLimited(100001, 10));
    }
}
