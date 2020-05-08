import java.util.Arrays;
import java.util.Scanner;

public class Day28 {
   //年会抽奖

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
           int n=scanner.nextInt();
           double possibility=fun(n);
           double count=falseSort(n);
           double result = (count/possibility)*100;
           System.out.println(String.format("%.2f", result) + "%");
        }
    }

    private static double falseSort(int n) {
        if (n==1){
            return 0;
        }

        if (n==2){
            return 1;
        }

        return  (n-1)*(falseSort(n-2)+falseSort(n-1));
    }

    private static double fun(int n) {
        if (n==0||n==1){
            return  1;
        }

        return n*fun(n-1);
    }


    //数字和为sum的方法数
    //回溯
    static int  times;
    public  static void fun(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num=scanner.nextInt();
            int sum=scanner.nextInt();
            int[]arr=new int[num];
            for(int i=0;i<num;i++){
                arr[i]=scanner.nextInt();
            }
            Arrays.sort(arr);
            dfs(arr,sum,0);
            System.out.println(times);
        }
    }

    private static void dfs(int[] arr, int sum, int start) {
        if (sum==0){
            times++;
            return;
        }

        for(int i=start;i<arr.length;i++){
            if (arr[i]>sum){
               break;
            }
            sum-=arr[i];
            dfs(arr,sum,i+1);
            sum+=arr[i];
        }
    }

}
