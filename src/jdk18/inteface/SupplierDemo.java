package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.function.Supplier;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class SupplierDemo {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};
        /**
         * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
         */
        Supplier<String> supplier = String::new;
        String s = supplier.get();
        comUtil.print(1,s);

        Supplier<String> supplier1 = ()->{ return "213123";} ;
        comUtil.print(2,supplier1.get());

        Supplier<ComUtil> supplier2 =()->()->{};
        supplier2.get().print(3,"ds");
    }
}
