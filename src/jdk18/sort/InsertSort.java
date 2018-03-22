package jdk18.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by thomas on 2018/3/22.
 */
public class InsertSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10000);
        for (int i =0;i<10000;i++){
            list.add(ThreadLocalRandom.current().nextInt(1,100));
        }
        InsertSort  obj=new InsertSort();
        System.out.println("初始值：");
        obj.print(list);
        obj.insertSort(list);
        System.out.println("\n排序后：");
        obj.print(list);
    }
    public void print(List<Integer> a){
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
    }
    public void insertSort(List<Integer> a) {
        for(int i=1;i<a.size();i++){//从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
            int j;
            int x=a.get(i);//x为待插入元素
            for( j=i;  j>0 && x<a.get(j-1);j--){//通过循环，逐个后移一位找到要插入的位置。
                a.set(j,a.get(j-1)) ;
            }
            a.set(j,x);//插入
        }
    }
}
