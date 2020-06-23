package June;

public class Day15 {
    //二进制求和
    public static String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int add=0;

        while (i>=0||j>=0){
           add+=i>=0?a.charAt(i)-'0':0;
           add+=j>=0?b.charAt(j)-'0':0;

           sb.append((char)(add%2+'0'));
           add/=2;

           i--;
           j--;
        }
        if (add==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
