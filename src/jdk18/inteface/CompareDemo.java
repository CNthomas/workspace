package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.Comparator;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class CompareDemo {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};

        /**
         * Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：
         */
        Comparator<Integer> comparator = (s1,s2)->{return s1.compareTo(s2);};
        comUtil.print(1,comparator.compare(1,2));

        Comparator<Integer> comparator1= Comparator.naturalOrder();
        comUtil.print(1,comparator.compare(127,128));
        comUtil.print(1,comparator.compare(128,128));
        comUtil.print(1,comparator.reversed().compare(129,128));
    }
}
