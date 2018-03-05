package jdk18.designpatter.securityFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 2018/3/2.
 */
public class Client {
    public static void main(String[] args) {
        List<Filter> list = new ArrayList<>();
        for (int i =0;i<10000;i++) {
            list.add(new Test1Filter());
            list.add(new Test2Filter());
        }
        VirtualFilterChain filterChain = new VirtualFilterChain(null,list);
        filterChain.doFilter("request111","response1111");
        VirtualFilterChain filterChain1 = new VirtualFilterChain(filterChain,list);
        filterChain1.doFilter("testr","testp");
    }
}
