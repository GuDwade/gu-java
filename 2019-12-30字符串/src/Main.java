import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
interface Condition{
   boolean judge(String str,String str1);
}
class Equals implements  Condition{
    @Override
    public boolean judge(String str, String str1) {
        return  str.equals(str1);
    }
}
class LessThan implements  Condition{
    @Override
    public boolean judge(String str, String str1) {
        return  str.compareTo(str1)<0;
    }
}
public class Main {
    public static List<String>  find(List<String>origin,String s,Condition condition){
        List<String>result=new ArrayList<>();
        for(String s1:origin){
            if(condition.judge(s1,s)){
                result.add(s1);
            }
        }
        return result;
    }
    public static List<String>  findEquals(List<String>origin,String s){
        return find(origin,s,new Equals());
    }
    public static List<String>  findLessThan(List<String>origin,String s){
        return find(origin,s,new LessThan());
    }
    /*
    public static List<String>  findEquals(List<String>origin,String s){
        List<String>result=new ArrayList<>();
        for(String s1:origin){
            if(s1.equals(s)){
                result.add(s1);
            }
        }
        return result;
    }
    public static List<String>  findLessThsn(List<String>origin,String s){
        List<String>result=new ArrayList<>();
        for(String s1:origin){
            if(s1.compareTo(s)<0){
                result.add(s1);
            }
        }
        return result;
    }
    public static List<String>  findContains(List<String>origin,String s){
        List<String>result=new ArrayList<>();
        for(String s1:origin){
            if(s1.contains(s)){
                result.add(s1);
            }
        }
        return result;
    }
    */
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("java");
        list.add("mysql");
        list.add("abc");
        list.add("mysbl");
        System.out.println(findEquals(list,"java"));
        System.out.println(findLessThan(list,"hgghjgf"));
        String bool="gfc good good study";
        String[]str1=bool.split(bool);
        System.out.println(Arrays.toString(str1));
        String web="www.baidu.com";
        String[] str2=web.split("\\.");
        System.out.println(Arrays.toString(str2));
        String[]subdomain={"www","baidu","com"};
        String s=String.join(".",subdomain);
        System.out.println(s);
    }
}
