package com.joy.fresh.model.enumExample;

/**
 * Created by jianyuanhao on 18-4-4.
 */
// Java中允许在枚举中添加任意的方法和域，并实现任意的接口。
// 下面先给出一个带有域方法和域字段的枚举声明：
public enum Planet {
    MERCURY(3.302e+23, 2.439e6), VENUS(4.869e+24, 6.052e6), EARTH(5.975e+24, 6.378e6), MARS(6.419e+23,
            3.393e6), JUPITER(1.899e+27,
                    7.149e7), SATURN(5.685e+26, 6.027e7), URANUS(8.683e+25, 2.556e7), NEPTUNE(1.024e+26, 2.477e7);
    private final double mass; // 千克
    private final double radius; // 米
    private final double surfaceGravity;
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("1");
        double y = Double.parseDouble("1");
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
