import java.util.Scanner;

public class Day40 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scan.nextInt();
            }
            System.out.println(maxSum(arr,n));
        }
    }
    //连续最大和
    private static int maxSum(int[] arr, int n) {

        if (n==1){
            return arr[0];
        }

        int[]dp=new int[n];
        int max=arr[0];
        dp[0]=arr[0];

        for(int i=1;i<n;i++){
            dp[i]=Math.max(arr[i]+dp[i-1],arr[i]);
            max=Math.max(max,dp[i]);
        }

        return max;
    }

    //坐标移动 
    public static void game() {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            String []arr=str.split(";");
            int[]ret=new int[2];
            for(String idx:arr){
                if (idx.length()>3){
                    continue;
                }
                boolean flag=true;
                for(int i=1;i<idx.length();i++){
                    if (idx.charAt(i)<'0'||idx.charAt(i)>'9'){
                        flag=false;
                    }
                }

                if (idx.startsWith("A")&&flag){
                    ret[0]-=Integer.valueOf(idx.substring(1));
                }

                if (idx.startsWith("D")&&flag){
                    ret[0]+=Integer.valueOf(idx.substring(1));
                }

                if (idx.startsWith("W")&&flag){
                    ret[1]+=Integer.valueOf(idx.substring(1));
                }

                if (idx.startsWith("S")&&flag){
                    ret[1]-=Integer.valueOf(idx.substring(1));
                }

            }
            System.out.println(ret[0]+","+ret[1]);
        }
    }
}
