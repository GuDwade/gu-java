import java.util.ArrayList;
import java.util.List;

public class Day35 {
    //括号生成
     List<String> res = new ArrayList<>();
    public  List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    public  void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }

        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0||strs==null){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
    //外观数列
    public String countAndSay(int n) {
        if(n==1){
            return new String("1");
        }
        String[]dp=new String[n];
        dp[0]="1";
        for(int i=1;i<n;i++){
            String str=dp[i-1];
            StringBuilder sb=new StringBuilder();
            int j=0;
            while(j<str.length()){
                char tmp=str.charAt(j);
                int count=0;
                while (j<str.length()&&tmp==str.charAt(j)){
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(tmp);
            }
            dp[i]=sb.toString();
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        String str=longestCommonPrefix(new String[]{"flower","flow","floe"});
        generateParenthesis(3);
    }
}
