import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Day3 {
    public static void main(String[] args) {
        //买苹果
        /*
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int count=Integer.MAX_VALUE;
        for(int i=0;i<=n/6;i++){
            for(int j=0;j<=n/8;j++){
                if(i*6+j*8==n&&i+j<count){
                    count=i+j;
                }
            }
        }
        System.out.println( count==Integer.MAX_VALUE ?-1:count);
        */

        //去字符
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();


        Set<Character>set=new HashSet<>();
        for(char ch:b.toCharArray()){
            set.add(ch);
        }

        LinkedList<Character>list=new LinkedList<>();
        for(char ch:a.toCharArray()){
            if(!set.contains(ch)){
                list.add(ch);
            }
        }

        char[]ch=new char[list.size()];
        for(int i=0;i<list.size();i++){
            ch[i]=list.get(i);
        }
        String ret=new String(ch);
        System.out.println(ret);

    }
}
