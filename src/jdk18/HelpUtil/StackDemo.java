package jdk18.HelpUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by itw_yuekui on 2018/1/10.
 */
public class StackDemo {
    public static void main(String[] args){
        ComUtil comUtil = ()->{};
        Deque<String> deque = new ArrayDeque<>(3000) ;
        deque.push("1");
        deque.push("2");
        deque.push("3");
        deque.push("4");
        comUtil.print(1,deque.pop());
        comUtil.print(1,deque.pop());
        comUtil.print(1,deque.pop());
        comUtil.print(1,deque.pop());
    }
}
