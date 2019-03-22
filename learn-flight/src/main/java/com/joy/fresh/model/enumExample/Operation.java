package com.joy.fresh.model.enumExample;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianyuanhao on 18-4-5.
 */
// 代码已经表达出这种根据不同的枚举值，
// 执行不同的操作。但是上面的代码在设计方面确实存在一定的缺陷，或者说漏洞，如果我们新增枚举值的时候，所有和apply类似的域函数，都需要进行相应的修改，如有遗漏将会导致异常的抛出。幸运的是，Java的枚举提供了一种更好的方法可以将不同的行为与每个枚举常量关联起来：在枚举类型中声明一个抽象的apply方法，
// 并在特定于常量的类主体中，用具体的方法覆盖每个常量的抽象apply方法，如：

public enum Operation {
    PLUS("+") {
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    // 新增代码
    private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
    static {
        for (Operation op : values())
            stringToEnum.put(op.toString(), op);
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}