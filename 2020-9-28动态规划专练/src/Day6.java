import java.util.ArrayList;
import java.util.List;

public class Day6 {

    //不同的子序列
    public static int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][]dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j];
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }

        return  dp[n][m];
    }

    //分割回文串
    List<String>path;
    List<List<String>>ret;
    public List<List<String>> partition(String s) {
        path=new ArrayList<>();
        ret=new ArrayList<>();
        if (s.length()==0){
            return  ret;
        }
        dfs(s,0);
        return  ret;
    }

    private void dfs(String s, int idx) {
        if (idx==s.length()){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if (!isHuiWen(s,idx,i)){
                continue;
            }

            path.add(s.substring(idx,i+1));
            dfs(s,i+1);
            path.remove(path.size()-1);
        }
    }

    private boolean isHuiWen(String s, int l, int r) {
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
                return  false;
            }else{
                l++;
                r--;
            }
        }

        return  true;
    }

    //分割回文串 II
    public int minCut(String s) {
        int n=s.length();
        boolean[][]dp=new boolean[n][n];

        for(int i=1;i<=n;i++){
            for(int j=0;j+i-1<n;j++){
                int l=j,r=j+i-1;
                dp[l][r]=s.charAt(l)==s.charAt(r)&&(l+1>r-1||dp[l+1][r-1]);
            }
        }

        int[]f=new int[n+1];
        f[0]=0;
        for(int i=1;i<=n;i++){
            f[i]=Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                if (dp[j-1][i-1]){
                    f[i]=Math.min(f[i],f[j-1]+1);
                }
            }
        }

        return f[n]-1;

    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        Day6 test=new Day6();
        System.out.println(test.partition("aab"));
        System.out.println(test.minCut("aab"));
    }
}
