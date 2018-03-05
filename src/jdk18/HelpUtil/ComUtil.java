package jdk18.HelpUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
@FunctionalInterface
public interface ComUtil {
    ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    String CONSTR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    void defalut();
    default void print(Integer i,Object val){
        System.out.println("[col is->"+i+":"+(val==null?"":val.toString())+"]");
    }
    default int randomInt(){
        return RANDOM.nextInt();
    }
    default int rangeInt(int o,int b ){
        return RANDOM.nextInt(o,b);
    }
    default float randomFloat(){
        return RANDOM.nextFloat();
    }
    default String randomStr(int n){
        StringBuffer s =new StringBuffer();
        while (s.length() != n){
            s.append(CONSTR.charAt(RANDOM.nextInt(0,CONSTR.length()-1)));
        }
        return s.toString();
    }
}
