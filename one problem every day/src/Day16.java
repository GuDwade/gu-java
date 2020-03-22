import java.util.Arrays;

public class Day16 {
    //使数组唯一的最小增量
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count=0;
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                int prev=A[i];    //记录原来的值
                A[i]=A[i-1]+1;    //变化后了的值
                count+=A[i]-prev; //变化了多少
            }
        }
        return count;
    }

}
