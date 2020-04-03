import java.util.Scanner;
import java.util.Stack;

public class Day4 {
    //用栈创建队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /*
    private  static int count;
    private static int[] bag;

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        count=scan.nextInt();
        bag=new int[count];
        for(int i=0;i<count;i++){
            bag[i]=scan.nextInt();
        }
        System.out.println(count(0,40));
    }

    public static int count(int i,int sum){
        if(sum==0)
            return 1;
        if(i==count||sum<0)
            return 0;
        return count(i+1,sum)+count(i+1,sum-bag[i]);
    }
    */


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] bags=new int[n];
        //dp[i][j]表示前i个物品达到体积为j时，可以选择物品的方式
        int[][]dp=new int[n+1][41];
        for(int i=0;i<n;i++)
        {
            bags[i]=in.nextInt();
        }
        System.out.println(count(bags,dp));
    }

    //传入每个物体的体积和dp数组
    public static int  count(int[] bags,int[][] dp) {

        //dp[i][0] = 1; 达到体积0的方式只有1种，即不选物品
        for(int i=0;i<dp.length;i++) {
            dp[i][0]=1;
        }
        //dp[0][j] = 0; 达到体积j，j > 0, 但没有物品，没有方式可以做到，为0
        for(int j = 1;j<dp[0].length;j++){
            dp[0][j] = 0;
        }
        //遍历dp数组,为dp数组赋值
        for (int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(j>=bags[i-1]) {
                    //前i个物品达到体积为j时的方式=前i-1个物品达到体积为j时的方式+前i-个物品达到体积为j-items[i-1]的方式
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-bags[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[bags.length][40];
    }

}
