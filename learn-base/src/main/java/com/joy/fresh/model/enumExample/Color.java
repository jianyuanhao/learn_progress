package com.joy.fresh.model.enumExample;

/**
 * Created by jianyuanhao on 18-4-5.
 */
public enum Color {
    WHITE, RED, GREEN, BLUE, ORANGE, BLACK;
    public int indexOfColor() {
        return ordinal() + 1;
    }

    public static void main(String[] args) {
        System.out.println(WHITE.indexOfColor());
        System.out.println(RED.indexOfColor());
        System.out.println(GREEN.indexOfColor());
        System.out.println(BLUE.ordinal());
    }
}
