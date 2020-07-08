package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
    //跳水板
    List<Integer>list=new ArrayList<>();
    public int[] divingBoard(int shorter, int longer, int k) {

        if(k<=0){
            return new int[]{};
        }
        if (shorter==longer){
            return new int[]{shorter*k};
        }
        int[]arr={shorter,longer};
        dfs(arr,0,0,k);
        int[]ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        Arrays.sort(ret);
        return  ret;
    }

    private void dfs(int[] arr, int num, int sum,int k ) {

        if(num==k){
            if (!list.contains(sum)){
                list.add(sum);
            }
            return;
        }

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            num++;
            dfs(arr,num,sum,k);
            sum-=arr[i];
            num--;
        }
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if (shorter==longer){
            return new int[]{shorter*k};
        }

        int[] ret=new int[k+1];
        int min=shorter*k;
        for(int i=0;i<=k;i++){
            ret[i]=min+(longer-shorter)*i;
        }
        return  ret;
    }

    public static void main(String[] args) {
        Day9 test=new Day9();
        System.out.println(Arrays.toString(test.divingBoard(1, 2, 3)));
    }
}
