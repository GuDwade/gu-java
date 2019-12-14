import java.util.TreeSet;

class userName implements Comparable{
    public String sName;
    public userName(String sName){
        this.sName=sName;
    }
    public int compareTo(Object o){
        userName tempuser=(userName)o;
        String temp=tempuser.sName;
        return this.sName.compareTo(temp);
    }
    public String toString(){
        return this.sName;
    }
}
public class UserNameSort {
    public static void main(String[] args) {
        System.out.println("排序后顺序为：");
        TreeSet ts=new TreeSet();
        ts.add(new userName("gufucheng"));
        ts.add(new userName("gucheng"));
        ts.add(new userName("luocheng"));
        System.out.println(ts);
    }
}
