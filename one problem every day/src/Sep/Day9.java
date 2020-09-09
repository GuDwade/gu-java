package Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
    List<List<Integer>>ret;
    List<Integer>path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return  ret;
    }

    private void dfs(int[] candidates, int target,int idx) {
        if (target<0){
            return;
        }

        if(target==0){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
           path.add(candidates[i]);
           dfs(candidates, target-candidates[i], i);
           path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Day9 test=new Day9();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
