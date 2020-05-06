import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    //电话号码的字母组合

    public List<String> letterCombinations(String digits) {
            String []chars={"abc","def","ghi","jkl","mno","pqrt","tuv","wxyz"};
            List<String>state=new ArrayList<>();
            if (digits==null||digits.length()==0){
                return  state;
            }
            state.add("");

            for(char ch:digits.toCharArray()){
                List<String>now=new ArrayList<>();
                for(char tmp:chars[ch-'2'].toCharArray()){
                    for(String s:state){
                        now.add(s+tmp);
                    }
                }
                state=now;
            }

            return  state;
    }

    //单词搜索

    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return  false;
        }
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (dfs(board,i,j,word,0)){
                    return  true;
                }
            }
        }
        return  false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int idx) {
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};
        int n=board.length;
        int m=board[0].length;


        if (board[i][j]!=word.charAt(idx)){
            return  false;
        }
        if (idx==word.length()-1){
            return  true;
        }

        board[i][j]='*';
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<n&&y>=0&&y<m){
                if (dfs(board,x,y,word,idx+1)){
                    return  true;
                }
            }
        }
        board[i][j]=word.charAt(idx);
        return  false;
    }

    //全排列
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        dfs1(res,list,nums);
        return  res;
    }

    private void dfs1(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int num:nums){
            if (!list.contains(num)){
                list.add(num);
                dfs1(res,list,nums);
                list.remove(list.size()-1);
            }
        }
    }

    int n;
    List<List<Integer>>res;
    List<Integer>path;
    int []vis;

    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList();
        path=new ArrayList();
        n=nums.length;
        vis=new int[n];
        dfs(nums,0);
        return  res;
    }

    private void dfs(int[] nums, int idx) {
        if (idx==n){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i=0;i<n;i++){
            if (vis[i]==0){
                vis[i]=1;
                path.add(nums[i]);
                dfs(nums,idx+1);
                vis[i]=0;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s="abc";
        char c='d';
        System.out.println(s+c);
        char[][]board ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        boolean bool=exist(board,"SEE");


    }
}
