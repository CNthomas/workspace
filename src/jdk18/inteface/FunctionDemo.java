package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.function.Function;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class FunctionDemo {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};
        /**
         *         Function 接口有一个参数并且返回一个结果，
         *         并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
         */
        Function<String,Integer> function =(s)->Integer.valueOf(s);
        comUtil.print(1,function.apply("12345"));

        Function<Integer,Integer> function1 = (s)->s*s*s;
        comUtil.print(2,function1.apply(2));
        comUtil.print(2,function1.apply(4));
        /**
         * s*s*s/2
         */
        comUtil.print(3,function1.andThen((s)->s/2).apply(2));
        comUtil.print(3,function1.andThen((s)->s/2+"hello").apply(2));
    }
}
