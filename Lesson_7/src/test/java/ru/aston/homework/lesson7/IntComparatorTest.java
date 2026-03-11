package ru.aston.homework.lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IntComparatorTest {

    private final IntComparator comparator = new IntComparator();

    @Test
    public void compareLess() {
        assertTrue(comparator.compare(1, 2) < 0);
    }

    @Test
    public void compareEqual() {
        assertEquals(comparator.compare(5, 5), 0);
    }

    @Test
    public void compareGreater() {
        assertTrue(comparator.compare(10, 3) > 0);
    }

    // некорректный тест
    @Test
    public void compareWrongAssertion() {
        // на самом деле 2 > 1
        assertTrue(comparator.compare(1, 2) > 0);
    }
}
