package com.joy.fresh.service.method;

import java.util.Date;

/**
 * Created by jianyuanhao on 18-4-5.
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        // Why:Date类本身是可变,为了避免这样的攻击，
        //    我们需要对Period的构造函数进行相应的修改，
        //    即对每个可变参数进行保护性拷贝
        // Remind:保护性拷贝是在坚持参数有效性之前进行的，
        //   并且有效性检查是针对拷贝之后的对象，而不是针对原始对象的
        // for:避免在this.start = new Date(start.getTime())到
        //   if (start.compareTo(end) > 0)这个时间窗口内，
        //   参数start和end可能会被其他线程修改
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "After " + end);
        }
        // this.start = start;
        // this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    public static void main(String[] args) {
        // 从表面上看，该类的实现确实对约束性的条件进行了验证，
        // 然而由于Date类本身是可变了，因此很容易违反这个约束，见如下代码：
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78); // 该修改将直接影响Period内部的end对象。
    }
}
