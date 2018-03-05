package jdk18.designpatter.securityFilter;

import jdk18.HelpUtil.ComUtil;

/**
 * Created by thomas on 2018/3/2.
 */
public class Test2Filter implements Filter{
    @Override
    public void doFilter(String request, String response, FilterChain chain) {
        ComUtil comUtil = ()->{};
        comUtil.print(2,request+"|"+response+"1"+chain);
        chain.doFilter(request,response);
    }
}
