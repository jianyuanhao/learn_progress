package com.joy.fresh.mode.singleton;

/**
 * Created by jianyuanhao on 18-4-26.
 */
public class Test {
    public class Abc {
        private Abc() {
        };

        Abc n1 = new Abc();

        Abc getSingle() {
            return n1;
        }
    }

    public class Cbd {
        public Cbd() {
            Abc n1, n2;
        }
    }
}
