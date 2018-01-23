package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.function.Consumer;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};
        /**
         * Consumer 接口表示执行在单个参数上的操作。
         */
        Consumer<Integer> consumer = (s)->comUtil.print(1,s*s);
        consumer.accept(12);
        /**
         * s*s*s->s*s
         */
        Consumer<Integer> consumer1 = (s)->comUtil.print(2,s*s*s);
        consumer1.andThen((s)->comUtil.print(3,s*s)).accept(2);
    }
}
