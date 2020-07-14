package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day16 {
    //三角形最小路径和
    int buttom;
    int min;
    public int minimumTotal1(List<List<Integer>> triangle) {
        buttom=triangle.size();
        min=Integer.MAX_VALUE;
        dfs(0,0,0,triangle);
        return min;
    }

    private void dfs(int level, int idx,int sum,List<List<Integer>> triangle) {
        if(level==buttom){
            if(sum<min){
                min=sum;
            }
            return;
        }

        int end=Math.min(idx+1,triangle.get(level).size()-1);
        for(int i=idx;i<=end;i++){
            sum+=triangle.get(level).get(i);
            level++;
            dfs(level,i,sum,triangle);
            level--;
            sum-=triangle.get(level).get(i);

        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        List<Integer> list1=Arrays.asList(new Integer[]{2});
        List<Integer> list2=Arrays.asList(new Integer[]{3,4});
        List<Integer> list3=Arrays.asList(new Integer[]{6,5,7});
        List<Integer> list4=Arrays.asList(new Integer[]{4,1,8,3});

        List<List<Integer>>triangle=new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        Day16 test=new Day16();
        System.out.println(test.minimumTotal(triangle));
    }
}
