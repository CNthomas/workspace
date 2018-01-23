package jdk18.HelpUtil;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
@FunctionalInterface
public interface ComUtil {
    void defalut();
    default void print(Integer i,Object val){
        System.out.println("[col is->"+i+":"+(val==null?"":val.toString())+"]");
    }
}
