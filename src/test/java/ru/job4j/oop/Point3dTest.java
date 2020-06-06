package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class Point3dTest {

    @Test
    public void distance() {
        Point3d d = new Point3d(2, 3);
        Point3d v = new Point3d(6, 8);
        double result = Math.round(d.distance(v));
        double expected = 6;
        assertThat(result, is(expected));
    }
    @Test
    public void distance3d() {
        Point3d d = new Point3d(2,6,8);
        Point3d v = new Point3d(1, 3, 4);
        double result =Math.round(d.distance3d(v));
        double expected = 7;
        assertThat(result, is(expected));
    }
    @Test
    public void info() {
    }
}