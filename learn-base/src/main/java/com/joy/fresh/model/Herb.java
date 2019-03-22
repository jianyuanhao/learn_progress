package com.joy.fresh.model;

/**
 * Created by jianyuanhao on 18-4-5.
 */
public class Herb {
    public enum Type {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    private final String name;
    private final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

//    public static void main(String[] args) {
//        Herb[] garden = getAllHerbsFromGarden();
//        Set<Herb> herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
//        for (int i = 0; i < herbsByType.length; ++i) {
//            herbsByType[i] = new HashSet<Herb>();
//        }
//        for (Herb h : garden) {
//            herbsByType[h.type.ordinal()].add(h);
//        }
//        for (int i = 0; i < herbsByType.length; ++i) {
//            System.out.printf("%s: %s%n", Herb.Type.values()[i], herbByType[i]);
//        }
//    }
}
