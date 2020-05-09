import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day29 {
    //奇偶校验
    //3指的是'3'对应Ascii中的51；
    //奇偶指的是二进制中1的个数
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.next();
            for(char ch:str.toCharArray()){
                System.out.println(change(ch));
            }
        }

    }

    private static String change(char ch) {
        int x=ch;
        int num=0;
        char []arr=new char[8];
        Arrays.fill(arr,'0');
        int idx=arr.length-1;
        while (x!=0){
            int mod=x%2;
            if (mod==1){
                num++;
            }
            arr[idx--]=(char)(mod+48);
            x/=2;
        }
        if (num%2==0){
            arr[0]='1';
        }
        return new String(arr);
    }

    //大整数排序
    public static  void bigIntegerSort(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            String[]arr=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.next();
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int ret=o1.length()-o2.length();
                    if (ret<0){
                        return  -1;
                    }
                    if(ret>0){
                        return  1;
                    }
                    if (ret==0){
                        for(int i=0;i<o1.length();i++){
                            if (o1.charAt(i)<o2.charAt(i)){
                                return  -1;
                            }
                            if (o1.charAt(i)>o2.charAt(i)){
                                return  1;
                            }
                        }
                    }
                    return  0;
                }
            });

            for (String str:arr){
                System.out.println(str);
            }
        }
    }


}
