package com.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    @Test
    void addsNumbers() {
        assertEquals(5, Calc.add(2, 3));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(20, Calc.mul(4, 5));
    }

    @Test
    void detectsEven() {
        assertTrue(Calc.isEven(6));
        assertFalse(Calc.isEven(7));
    }

    @Test
    void flakyAddsUnderLoad() {
        if (ThreadLocalRandom.current().nextDouble() < 0.4) {
            fail("flaky: simulated timeout while adding");
        }
        assertEquals(2, Calc.add(1, 1));
    }

    @Test
    void flakyMultipliesUnderContention() {
        if (ThreadLocalRandom.current().nextDouble() < 0.4) {
            fail("flaky: simulated contention in multiplier");
        }
        assertEquals(9, Calc.mul(3, 3));
    }
}
