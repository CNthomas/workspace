package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.Optional;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};
        /**
         *  Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，
         *  这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：
         *  Optional 被定义为一个简单的容器，其值可能是null或者不是null。
         *  在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，
         *  而在Java 8中，不推荐你返回null而是返回Optional。
         */
        Optional<String> optional = Optional.of("123");
        comUtil.print(1,optional.get());
        comUtil.print(1,optional.isPresent());
        comUtil.print(1,optional.orElse("345"));

        Optional<String> optional1 = Optional.ofNullable(null);
        comUtil.print(1,optional1.orElseGet(()->"1234"));
        comUtil.print(1,optional1.isPresent());
        comUtil.print(1,optional1.orElse("345"));
        final String t = "12334";
        optional1.ifPresent((s)->{comUtil.print(2,t+s);});

    }
}
