import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {
    //组合总数 1 2 3

    List<List<Integer>>ans;
    List<Integer>list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList();
        list=new ArrayList();
        dfs1(candidates,target,0);
        return  ans;
    }

    private void dfs1(int[] candidates, int target,int start) {
        if (target<0){
            return;
        }

        if (target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs1(candidates, target-candidates[i],i);
            list.remove(list.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList();
        list=new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return  ans;
    }



    private void dfs(int[] candidates, int target,int start) {

        if (target==0&&!ans.contains(list)){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i=start;i<candidates.length;i++){
            if (target-candidates[i]<0){
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target-candidates[i],i+1);
            list.remove(list.size()-1);
        }

    }


    List<List<Integer>>res;
    List<Integer>path;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res=new ArrayList();
        path=new ArrayList();
        dfs(k,1,n);
        return  res;
    }

    private  void dfs(int k,int start,int n){
        if (k==0){
            if (n==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=start;i<=9;i++){
            path.add(i);
            dfs(k-1,i+1,n-i);
            path.remove(path.size()-1);
        }
    }

}
