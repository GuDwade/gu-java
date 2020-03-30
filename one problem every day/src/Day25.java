import java.util.Arrays;
import java.util.Scanner;

public class Day25 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String str1=scan.nextLine();;
        String str2=scan.nextLine(); ;

        StringBuilder sb=new StringBuilder(str1);
        int count=0;
        for(int i=0;i<str1.length();i++){
          StringBuilder sb1=new StringBuilder(sb.substring(0,i+1));
          sb1.append(str2);
          StringBuilder sb2=new StringBuilder(sb.substring(i+1));
          sb1.append(sb2);
          if(isHuiWen(sb1.toString())){
              count++;
          }
        }
        System.out.println(count);


    }

    public static boolean isHuiWen(String str){
        int start=0;
        int end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
