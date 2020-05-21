import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day39 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String setence=scanner.nextLine();
        System.out.println(reverse(setence));
    }

    public static String reverse(String sentence){
        int left=sentence.length()-1;
        int right=sentence.length()-1;
        StringBuilder sb=new StringBuilder();
        while (right>=0){
            while (right>=0&&sentence.charAt(right)!=' '){
                right--;
            }
            sb.append(sentence.substring(right+1,left+1));
            if (right>0){
                sb.append(' ');
            }
            left=right;
            while (left>=0&&sentence.charAt(left)==' '){
                left--;
            }
            right=left;
        }
        return sb.toString();
    }

    private void delete(){
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        StringBuilder sb=new StringBuilder();
        for(char ch:str1.toCharArray()){
            if(ch==' '||ch=='.'||str2.indexOf(ch)==-1){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
    private static int fibonacci(int n) {

        int a=0,b=1;
        while (b<=n){
            int tmp=a+b;
            a=b;
            b=tmp;
        }
        return Math.min(n-a,b-n);
    }

    public  static  void kitchen(){
        Scanner scan=new Scanner(System.in);
        Set<String> set=new HashSet<>();
        while (scan.hasNext()){
            String str=scan.next();
            if (!set.contains(str)){
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}
