import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 京东 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            int i=0;
            int j=0;
            while (i<str.length()){
                while (i<str.length()&&!isNumber(str.charAt(i))){
                    i++;
                }
                j=i;
                while (j<str.length()&&isNumber(str.charAt(j))){
                    j++;
                }
                if(j<=str.length()&&j-i==4){
                    if (isRightYear(str.substring(i,j))&&!list.contains(Integer.valueOf(str.substring(i,j)))){
                        list.add(Integer.valueOf(str.substring(i,j)));
                    }
                }
                i=j;
            }
            for(int k=0;k<list.size();k++){
                System.out.print(list.get(k));
                if (k!=list.size()-1){
                    System.out.print(" ");
                }
            }
        }

    }


    static int day=0;
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            double n=scan.nextInt();
            double m=scan.nextInt()*100;
            dfs(n,m,0,1,0);
            System.out.println(day);
        }
    }

    private static void dfs(double n, double m, double down, int fac,double up) {
        day++;
        up+=n;
        if (up>=m){
           return;
        }
        int x=1;
        int f=fac;
        while (f>0){
            x*=2;
            f--;
        }
        down+=n/x;
        up-=down;
        dfs(n,m,down,fac+1,up);

    }

    private static boolean isRightYear(String substring) {
        return  Integer.valueOf(substring)>=1000&&Integer.valueOf(substring)<=3999;
    }

    private static boolean isNumber(char c) {
        if(c>='0'&&c<='9'){
            return  true;
        }
        return  false;
    }
}
