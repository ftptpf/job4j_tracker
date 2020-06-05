package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;
    public Triangle (Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    public double perimeter(double a, double b, double c) {
        if (this.exist(a,b,c)) {
            return (a + b + c) / 2;
        }
        return -1;
    }
    public double aria() {
        double rls = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = perimeter(a, b, c);
        if (this.exist(a, b, c)) {
            rls = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
        return rls;
    }
    private boolean exist(double a, double b, double c) {
        if(a >= b + c || b >= a + c || c >= a + b) {
            return false;
        }
        return true;
    }
}
