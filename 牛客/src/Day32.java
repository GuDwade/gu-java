import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day32 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String input=scan.nextLine();
            String output=scan.nextLine();
            brokenKeyboard(input,output);
        }
    }
    //损坏的键盘
    private static void brokenKeyboard(String input, String output) {
       String str1=input.toUpperCase();
       String str2=output.toUpperCase();
        Set<Character>set=new HashSet<>();
        for(char ch:str1.toCharArray()){
            if(str2.indexOf(ch)==-1){
                set.add(ch);
            }
        }
        for (char ch:str1.toCharArray()){
            if (set.contains(ch)){
                System.out.print(ch);
                set.remove(ch);
            }
            if (set.isEmpty()){
                break;
            }
        }
        System.out.println();
    }
    //球的半径和体积
    public static  void V(){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int x0=scan.nextInt();
            int y0=scan.nextInt();
            int z0=scan.nextInt();
            int x1=scan.nextInt();
            int y1=scan.nextInt();
            int z1=scan.nextInt();

            double r=Math.sqrt(Math.pow(x1-x0,2)+Math.pow(y1-y0,2)+Math.pow(z1-z0,2));
            double v=4/3.0*Math.acos(-1)*Math.pow(r,3);
            //浮点类型数据输出
            System.out.println(String.format("%.3f", r)+" "+String.format("%.3f", v));
        }
    }
}
