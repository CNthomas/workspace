package jdk18.thread;

import java.util.concurrent.*;

/**
 * Created by thomas on 2018/3/5.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                Executors.defaultThreadFactory(),
               new MyRejectedExecutionHandler());
        System.out.println(service);
        int count = 0;
        for (int i=0;i<1000;i++){
            try {
                service.submit(new RunableImp(i));
                count++;
            }catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
            System.out.println(String.format("for------>%s",i));
        }
        System.out.println(String.format("count------>%s",count));
        service.shutdown();
    }

}
class MyRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class RunableImp implements Runnable{
    private final int index;
    public RunableImp(int index){
        this.index = index;
    }
    @Override
    public void run() {
        System.out.println(String.format("index------->%s|thread name--------->%s",index,Thread.currentThread().getName()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}