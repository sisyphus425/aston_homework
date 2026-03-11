package ru.aston.homework.lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntComparatorTest {

    private final IntComparator comparator = new IntComparator();

    @Test
    void compareLess() {
        assertTrue(comparator.compare(1, 2) < 0);
    }

    @Test
    void compareEqual() {
        assertEquals(0, comparator.compare(5, 5));
    }

    @Test
    void compareGreater() {
        assertTrue(comparator.compare(10, 3) > 0);
    }

    // некорректный тест
    @Test
    void compareWrongAssertion() {
        // на самом деле 2 > 1
        assertTrue(comparator.compare(1, 2) > 0);
    }

}
