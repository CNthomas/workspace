package jdk18.thread.limit_rate;

import jdk.nashorn.internal.ir.IfNode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by thomas on 2018/3/1.
 */
public class LimitQueue {
    private List<Object> contanner = new ArrayList<>();
    private final int limit = 10;
    private final int time = 1;
    private int count = 0;
    private long lastAccessTime = 0l ;
    public void put(Object o){
        this.contanner.add(o);
    }
    public Object take(){
        decide();
        Object o = null;
        if (contanner.size() >0) {
            o = contanner.get(0);
            contanner.remove(0);
        }
        return o;
    }

    private void decide() {
        long cut = LocalDateTime.now().getNano();
        System.out.println("cut:"+cut+"|"+"last:"+lastAccessTime+"|"+"min:"+(cut - lastAccessTime-TimeUnit.SECONDS.toNanos(time)));
        if (lastAccessTime == 0 || cut - lastAccessTime > TimeUnit.SECONDS.toNanos(time)){
            count = 1;
            lastAccessTime = cut;
        }else{
            if (count >= limit){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count=1;
                lastAccessTime = cut;
            }else{
                count ++;
            }
        }
    }

    public static void main(String[] args) {
        LimitQueue queue = new LimitQueue();
        for (int i = 0 ;i<1200;i++){
            queue.put(i);
        }
        long s = LocalDateTime.now().getNano();
        for (int i =0;i<1200;i++){
            System.out.println(queue.take());
        }
        long e = LocalDateTime.now().getNano();
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(e-s));
    }
}
