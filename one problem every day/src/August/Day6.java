package August;

import java.util.ArrayList;
import java.util.List;

public class Day6 {
    //回文对
    List<List<Integer>>ret;
    List<Integer>path;
    public List<List<Integer>> palindromePairs(String[] words) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        int []isUsed=new int[words.length];
        dfs(0,isUsed,words);
        return  ret;
    }

    private void dfs(int count,int[] isUsed,String[] words) {
        if (count==2){
            if (isHuiwen(path,words)){
                ret.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=0;i<words.length;i++){
            if (isUsed[i]==0){
                isUsed[i]=1;
                path.add(i);
                count++;
                dfs(count,isUsed,words);
                path.remove(path.size()-1);
                count--;
                isUsed[i]=0;
            }
        }
    }

    private boolean isHuiwen(List<Integer> path, String[] words) {
        String str=words[path.get(0)]+words[path.get(1)];
        int l=0;
        int r=str.length()-1;
        while (l<r){
            if (str.charAt(l)!=str.charAt(r)){
                return  false;
            }
            l++;
            r--;
        }
        return  true;
    }

    public static void main(String[] args) {
        Day6 test=new Day6();
        List<List<Integer>>list=test.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).get(0)+""+list.get(i).get(1));
        }
    }

}
