import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(100);
        list.add(1,33);
        list.add(20);
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(2,25);
        List<Integer>list2=new ArrayList<>();
        list2.add(333);
        list2.addAll(list);
        list.remove(2);
        System.out.println(list2);
        List<Integer>subList=new ArrayList<>();
        subList=list2.subList(0,2);
        System.out.println(subList);
        subList.add(0);
        subList.add(55);
        System.out.println(subList);
        System.out.println(subList.indexOf(0));
        System.out.println(subList.contains(55));
     }
}
