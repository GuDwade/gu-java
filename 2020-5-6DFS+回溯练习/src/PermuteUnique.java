import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    //全排列 II

    List<List<Integer>>ret;
    List<Integer>path;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        if (nums==null||nums.length==0){
            return  ret;
        }
        Arrays.sort(nums);
        boolean[]used=new boolean[nums.length];
        dfs(nums,0,used);
        return  ret;
    }

    private void dfs(int[] nums, int idx, boolean[] used) {
        if (idx==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if (used[i]){
                continue;
            }

            if(i>0&&nums[i]==nums[i-1]&&!used[i - 1]){
                continue;
            }

            path.add(nums[i]);
            used[i]=true;
            dfs(nums,idx+1,used);
            used[i]=false;
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        PermuteUnique test=new PermuteUnique();
        test.permuteUnique(new int[]{1,1,2});
    }
}
