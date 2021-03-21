import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        int n = nums.length;
        boolean[] isUsed = new boolean[n];

        dfs(nums,ret,road,isUsed,0,n);
        return  ret;
    }

//    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> road,boolean[] isUsed, int cnt,int n) {
//        if (cnt == n){
//            ret.add(new ArrayList<>(road));
//            return;
//        }
//
//        for (int i = 0 ; i < n; i++){
//            if (!isUsed[i]){
//                isUsed[i] = true;
//                road.add(nums[i]);
//                dfs(nums,ret,road,isUsed,cnt + 1,n);
//                isUsed[i] = false;
//                road.remove(road.size() - 1);
//            }
//        }
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        int n = nums.length;
        boolean[] isUsed = new boolean[n];
        Arrays.sort(nums);
        dfs(nums,ret,road,isUsed,0,n);
        return  ret;
    }

    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> road, boolean[] isUsed, int cnt, int n) {
        if (cnt == n){
            ret.add(new ArrayList<>(road));
            return;
        }

        for (int i = 0 ; i < n; i++){
            if (i >0 && nums[i] == nums[i - 1] && isUsed[i - 1]){
                continue;
            }

           if (!isUsed[i]){
               isUsed[i] = true;
               road.add(nums[i]);
               dfs(nums,ret,road,isUsed,cnt + 1,n);
               isUsed[i] = false;
               road.remove(road.size() - 1);
           }
       }

    }


}
