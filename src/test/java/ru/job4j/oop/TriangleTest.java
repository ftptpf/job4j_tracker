package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {

    @Test
    public void sumPerimeterOneTwoThree() {
        Point ap = new Point(0, 1);
        Point bp = new Point(0, 2);
        Point cp = new Point(1, 1);
        Triangle z = new Triangle(ap, bp, cp);
        double a = ap.distance(bp);
        double b = ap.distance(cp);
        double c = bp.distance(cp);
        double result = Math.round(z.perimeter(a, b, c));
        double expected = 2;
        assertThat(result, is(expected));
    }
    @Test
    public void sumPerimeterError() {
        Point ap = new Point(0, 0);
        Point bp = new Point(0, 0);
        Point cp = new Point(2, 0);
        Triangle z = new Triangle(ap, bp, cp);
        double a = ap.distance(bp);
        double b = ap.distance(cp);
        double c = bp.distance(cp);
        double result = z.perimeter(a, b, c);
        double expected = -1;
        assertThat(result, is(expected));
    }

    @Test
    public void ariaSum() {
        Point ap = new Point(2, 0);
        Point bp = new Point(2, 2);
        Point cp = new Point(0, 2);
        Triangle z = new Triangle(ap, bp, cp);
        double result = Math.round(z.aria());
        double expected = 2;
        assertThat(result, is(expected));
    }
    @Test
    public void ariaSumError() {
        Point ap = new Point(0, 0);
        Point bp = new Point(2, 2);
        Point cp = new Point(0, 0);
        Triangle z = new Triangle(ap, bp, cp);
        double result = z.aria();
        double expected = -1;
        assertThat(result, is(expected));
    }
}
