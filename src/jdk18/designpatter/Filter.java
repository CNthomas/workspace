package jdk18.designpatter;

import com.sun.org.apache.xpath.internal.operations.And;
import jdk18.HelpUtil.ComUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thomas on 2018/3/2.
 */
public class Filter {
    public static void main(String[] args) {
        ComUtil comUtil = ()->{};
        List<Resource>  resources = new ArrayList<>();
        for (int i=0;i<1000;i++){
            Resource resource = new Resource();
            resource.setAge(comUtil.rangeInt(20,100));
            resource.setName(comUtil.randomStr(10));
            resource.setIncome(comUtil.rangeInt(5000,10000));
            resources.add(resource);
        }
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(new NameFilter("a"));
        andFilter.addFilter(new AgeFilter(40));
        List<Resource> r = andFilter.doFilter(resources);
        OrFilter orFilter = new OrFilter();
        orFilter.addFilter(andFilter);
        orFilter.addFilter(new AgeFilter(70));
        r = orFilter.doFilter(resources);
        System.out.println(r);
    }

}

interface IFilter{
    List<Resource> doFilter(List<Resource> resources);
}
class NameFilter implements IFilter{
    private String matchName;
    public NameFilter(String matchName){
        this.matchName = matchName;
    }
    @Override
    public List<Resource> doFilter(List<Resource> resources) {
        return resources.stream().filter(x->x.getName().contains(matchName)).collect(Collectors.toList());
    }
}
class AgeFilter implements IFilter{
   public AgeFilter(int matchAge){
       this.matchAge = matchAge;
   }
    private int matchAge;

    @Override
    public List<Resource> doFilter(List<Resource> resources) {
        return resources.stream().filter(x->x.getAge() == matchAge).collect(Collectors.toList());
    }
}
class AndFilter implements IFilter{
    List<IFilter> ifilters = new ArrayList<>();
    public void addFilter(IFilter ifilter){
        ifilters.add(ifilter);
    }
    @Override
    public List<Resource> doFilter(List<Resource> resources) {
        List<Resource> list = resources;
        for (IFilter ifilter:ifilters){
            list = ifilter.doFilter(list);
        }
        return list;
    }
}
class OrFilter implements IFilter{
    List<IFilter> ifilters = new ArrayList<>();
    public void addFilter(IFilter ifilter){
        ifilters.add(ifilter);
    }
    @Override
    public List<Resource> doFilter(List<Resource> resources) {
        List<Resource> list = new ArrayList<>();
        for (IFilter ifilter:ifilters){
            list.addAll(ifilter.doFilter(resources));
        }
        return list;
    }
}
class Resource{
    private String name;
    private int  age;
    private float income;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getIncome() {
        return income;
    }


    public void setIncome(float income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", income=" + income +
                '}';
    }
}