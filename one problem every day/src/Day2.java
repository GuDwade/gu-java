import java.util.ArrayList;
import java.util.List;

public class Day2 {
    //和为 target 的连续正整数序列
    public static int[][] findContinuousSequence(int target) {
        //[1 2 3 ... target-1]
        List<int[]>list=new ArrayList<>();
        int left=1;
        int right=1;
        int sum=0;
        for(right=1;right<=target/2+1;right++){
            sum+=right;
            while(sum>target){
                //大于target 区间右移
                sum-=left;
                left++;
            }
            if(sum==target){
                //相等创建数组
                int[]tmp=new int[right-left+1];
                for(int i=0;i<tmp.length;i++){
                    //连续数列 第一个数位left
                    tmp[i]=left+i;
                }
                list.add(tmp);
            }
        }

        int[][]ret=new int[list.size()][];
        for(int j=0;j<list.size();j++){
             ret[j]=list.get(j);
        }
        return ret;
    }

    public static  void print(int[][]arr){
        int sz=arr.length;
        for(int i=0;i<sz;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][]arr=findContinuousSequence(15);
        print(arr);
    }
}
