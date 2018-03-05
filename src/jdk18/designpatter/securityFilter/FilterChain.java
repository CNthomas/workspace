package jdk18.designpatter.securityFilter;

/**
 * Created by thomas on 2018/3/2.
 */
public interface FilterChain {
    void doFilter(String request,String response);
}
