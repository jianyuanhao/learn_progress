package com.joy.fresh.model.enumExample;

import java.util.EnumSet;

/**
 * Created by jianyuanhao on 18-4-5.
 */
public enum ColorNew {
    WHITE(1), RED(2), GREEN(3), ORANGE(4), BLACK(5);
    private final int indexOfColor;

    ColorNew(int index) {
        this.indexOfColor = index;
    }

    public int indexOfColor() {
        return indexOfColor;
    }

    public static void main(String[] args) {
        System.out.println(Color.RED.indexOfColor());
        EnumSet<ColorNew> x = EnumSet.of(ColorNew.BLACK, ColorNew.GREEN);
        System.out.println(x);
        System.out.println(x.contains(ColorNew.GREEN));
        System.out.println(x.contains(ColorNew.RED));
    }
}
