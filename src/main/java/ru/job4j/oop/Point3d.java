package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point3d {
    private int x;
    private int y;
    private int z;
    public Point3d(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public Point3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double distance(Point3d that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public double distance3d(Point3d that) {
        return distance(that) + sqrt(pow(this.z - that.z, 2));
    }
    public void info() {
        System.out.println(String.format("Point3d[%s, %s, %s]", this.x, this.y, this.z));
    }
}
