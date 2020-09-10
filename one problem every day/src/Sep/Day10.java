package Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 {
    List<List<Integer>>ret;
    List<Integer>path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        if (candidates==null||candidates.length==0){
            return  ret;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return  ret;
    }

    private void dfs(int[] candidates, int target, int idx) {
        if (target==0&&!ret.contains(path)){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if (target-candidates[i]<0){
                break;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Day10 test=new Day10();
        System.out.println(test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
