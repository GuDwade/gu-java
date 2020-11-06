import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    @Test
    public  void test() {
        Collection col=new ArrayList();
        col.add(123);
        col.add("gu");
        col.add(new Person(12,"Tom"));
        col.add("456");

        Iterator it = col.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Iterator it1 = col.iterator();
        while (it1.hasNext()){
            Object obj=it1.next();
           if (obj.equals("gu")){
               it1.remove();
           }
        }
        System.out.println("========");

        Iterator it2 = col.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}

class  Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
