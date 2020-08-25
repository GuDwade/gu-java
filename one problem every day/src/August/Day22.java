package August;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day22 {
    //递增子序列
    List<Integer> list = new ArrayList<Integer>();
    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(-101, 0, nums);
        return ret;
    }


    public void dfs(int pre, int cur, int[] nums) {
        if (cur==nums.length){
            if (list.size()>=2){
                ret.add(new ArrayList<>(list));
            }
            return;
        }

        if (nums[cur]>=pre){
            list.add(nums[cur]);
            dfs(nums[cur],cur+1,nums);
            list.remove(list.size()-1);
        }

        if (nums[cur]!=pre){
            dfs(pre,cur+1,nums);
        }

    }


}
