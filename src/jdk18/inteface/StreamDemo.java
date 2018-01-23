package jdk18.inteface;

import jdk18.HelpUtil.ComUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by itw_yuekui on 2018/1/9.
 */
public class StreamDemo {
    public static void main(String[] args) {
        ComUtil comUtil = () -> {
        };
        /**
         * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
         * Stream 操作分为中间操作或者最终操作两种，
         * 最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，
         * 这样你就可以将多个操作依次串起来。
         * Stream 的创建需要指定一个数据源，
         * 比如 java.util.Collection的子类，List或者Set， Map不支持。
         * Stream的操作可以串行执行或者并行执行。
         */
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        long count = list.stream()
                .filter((s) -> Integer.valueOf(s).compareTo(5) >= 0)
                .count();
        comUtil.print(1, count);

        list.stream()
                .sorted((x, y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y)))
                .forEach((x) -> comUtil.print(2, x));
        list.parallelStream()
                .sorted((x, y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y)))
                .forEach((x) -> comUtil.print(2, x));
        Comparator<String> comparator = (x, y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y));
        comparator = comparator.reversed();

        list.stream()
                .sorted(comparator)
                .forEach((x) -> comUtil.print(3, x));

        List<String> r = list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println(r == list);
    }
}
