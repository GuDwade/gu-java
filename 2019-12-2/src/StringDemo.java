import java.util.List;

public class StringDemo {
    private static boolean Number(String s){
        for(char c:s.toCharArray()){
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
    private static List<String> compare(List<String>list,String str){
        for()

    }
    public static void main(String[] args) {
        /*String s="hello";
        s+=" ";
        s+="world";
        System.out.println(s);*/
        String s="123d55";
        System.out.println(Number(s));
    }
}
