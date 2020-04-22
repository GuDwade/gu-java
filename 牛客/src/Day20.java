import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day20 {
    static Map<Character,Character>table=new HashMap<>();
    public  static void buildTable(){
        table.put('A','V');table.put('B','W');table.put('C','X');
        table.put('D','Y');table.put('E','Z');table.put('F','A');
        table.put('G','B');table.put('H','C');table.put('I','D');
        table.put('J','E');table.put('K','F');table.put('L','G');
        table.put('M','H');table.put('N','I');table.put('O','J');
        table.put('P','K');table.put('Q','L');table.put('R','M');
        table.put('S','N');table.put('T','O');table.put('U','P');
        table.put('V','Q');table.put('W','R');table.put('X','S');
        table.put('Y','T');table.put('Z','U');table.put(' ',' ');
    }
    public  static String translate(String str){
        StringBuilder sb=new StringBuilder();
        for(char ch:str.toCharArray()){
            sb.append(table.get(ch));
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            System.out.println(getTotalCount(n));
        }

        buildTable();

    }

    //兔子
    public static int getTotalCount(int monthCount){
        if (monthCount<3){
            return 1;
        }
        int[]dp=new int[monthCount+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<monthCount+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[monthCount];
    }
}
