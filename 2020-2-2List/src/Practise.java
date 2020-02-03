import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Practise {
    public static void main(String[] args) {
        List<String> courses=new ArrayList<String>();
        courses.add("English");
        courses.add("Math");
        courses.add("Java");
        courses.add("Python");
        System.out.println(courses);
        System.out.println(courses.get(1));
        courses.set(1,"Chinese");
        System.out.println(courses.get(1));
        courses.add(1,"Math");
        System.out.println(courses);
        List<String> subCourses=courses.subList(1,4);//左闭右开
        System.out.println(subCourses);

        List<String>courses1=new ArrayList<String>(courses);
        System.out.println(courses1);
        List<String>courses2=new LinkedList<String>(courses);
        System.out.println(courses2);

        ArrayList<String>courses3=(ArrayList<String>) courses1;
        System.out.println(courses3);
        LinkedList<String>courses4=(LinkedList<String>)courses2;
        System.out.println(courses4);
    }
}
