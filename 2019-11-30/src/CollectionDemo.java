import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("顾富成");
        list.add("郭富城");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[]array=list.toArray();
        System.out.println(Arrays.toString(array));
        for(String s:list){
            System.out.println(s);
        }
        list.remove("郭富城");
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
