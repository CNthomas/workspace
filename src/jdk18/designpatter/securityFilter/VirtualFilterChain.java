package jdk18.designpatter.securityFilter;

import java.util.List;

/**
 * Created by thomas on 2018/3/2.
 */
public class VirtualFilterChain implements FilterChain {
    private final FilterChain originalChain;
    private final List<? extends Filter> additionalFilters;
    private int currentPosition = 0;
    public VirtualFilterChain(FilterChain chain,List<? extends Filter> additionalFilters){
        this.originalChain = chain;
        this.additionalFilters = additionalFilters;
    }
    @Override
    public void doFilter(String request, String response) {
        if (this.currentPosition == this.additionalFilters.size()){
            if (originalChain != null) {
                this.originalChain.doFilter(request, response);
            }
        }else {
            this.currentPosition++;
            Filter nextFilter = this.additionalFilters.get(currentPosition-1);
            nextFilter.doFilter(request,response,this);
        }
    }
}
