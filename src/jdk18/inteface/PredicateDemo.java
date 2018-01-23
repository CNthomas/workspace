package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class PredicateDemo {
    public static void main(String[] args) {
        /**
         * Predicate 接口只有一个参数，返回boolean类型。
         *该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）：
         */
        ComUtil comUtil = ()->{
            System.out.println("---init--");
        };
        comUtil.defalut();

        Predicate<String> predicate  = (s)->s.length()>0;
        comUtil.print(1,predicate.test(""));
        comUtil.print(1,predicate.negate().test("12345"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        comUtil.print(2,nonNull.test(Boolean.FALSE));
        comUtil.print(2,nonNull.test(null));

        Predicate<Boolean> isNull = Objects::isNull;
        comUtil.print(3,isNull.test(null));
        comUtil.print(3,isNull.test(Boolean.FALSE));

        Predicate<Object> objIsNull = Objects::isNull;
        comUtil.print(4,objIsNull.test(null));
        comUtil.print(4,objIsNull.test(predicate));

        Predicate<Object> objIsNotNull = Objects::nonNull;
        comUtil.print(5,objIsNotNull.test(null));
        comUtil.print(5,objIsNotNull.test(predicate));

        Predicate<String> isEmpty = String::isEmpty;
        comUtil.print(6,isEmpty.test(""));
        comUtil.print(6,isEmpty.test("    "));
        comUtil.print(6,isEmpty.test("12345"));


        Predicate<String> notEmpty = isEmpty.negate();
        comUtil.print(7,notEmpty.test(""));
        comUtil.print(7,notEmpty.test("    "));
        comUtil.print(7,notEmpty.test("12345"));
    }
}
