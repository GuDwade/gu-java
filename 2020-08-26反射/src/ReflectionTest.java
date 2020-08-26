import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ReflectionTest {
    public static void main(String[] args)throws Exception {
        //通过反射创建对象
        Class clazz=Person.class;
        Constructor cons=clazz.getConstructor(String.class,int.class);
        Object obj=cons.newInstance("gu",20);
        Person person= (Person) obj;
        System.out.println(person);

        //调用属性
        Field age=clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person);

        //调用方法
        Method method=clazz.getDeclaredMethod("show");
        method.invoke(person);

        //通过反射调用私有结构

        Constructor cons1=clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1= (Person) cons1.newInstance("wang");
        System.out.println(p1);

        //通过反射调用私有属性
        Field name=clazz.getDeclaredField("name");
        //true可以访问私有方法、属性
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

    }
}


class Person{
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public   void show(){
        System.out.println("顾哥好！！！");
    }
}