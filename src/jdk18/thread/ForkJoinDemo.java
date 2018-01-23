package jdk18.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by itw_yuekui on 2018/1/12.
 */
public class ForkJoinDemo {

    public static void main(String[] args)throws Exception {
        final int n = 12;
        final int p = 2;
        int a =0,b=0;
        ForkJoinPool pool = ForkJoinPool.commonPool();
        List<task> list = new ArrayList<>(1000) ;
        for (int i = 1; i <= n; i++){
            if (a == 0){
                a= i;
            }
            if ( i % p ==0){
                b=i;
                task t = new task(a, b);
                list.add(t);
                t.fork();
                a=0;
            }
        }
        int s = 1;
        for (task t:list){
            s =s * t.join();
        }
        System.out.println(s);
    }
}

class task extends RecursiveTask<Integer> {

    private Integer a;
    private Integer b;

    public task(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected Integer compute() {
        System.out.println("a->"+a+"b->"+b);
        return this.a * this.b;
    }
}
