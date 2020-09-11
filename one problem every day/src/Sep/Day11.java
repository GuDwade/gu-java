package Sep;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
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
