package August;

import java.util.ArrayList;
import java.util.List;

public class Day23 {

    //电话号码的字母组合

    String []chars={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String>ret=new ArrayList<>();
    StringBuilder sb=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return ret;
        }
        dfs(0,digits);
        return  ret;
    }

    private void dfs(int idx, String digits) {
        if (idx==digits.length()){
            ret.add(sb.toString());
            return;
        }

        String str=chars[digits.charAt(idx)-'2'];
        for(char c:str.toCharArray()){
            sb.append(c);
            dfs(idx+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits==null||digits.length()==0){
            return ret;
        }
        List<String>state=new ArrayList<>();
        state.add("");

        for(char ch:digits.toCharArray()){
            List<String>now=new ArrayList<>();
            for(char cur:chars[ch-'2'].toCharArray()){
                for(String s:state){
                    now.add(s+cur);
                }
            }
            state=now;
        }

        return  state;
    }
    public static void main(String[] args) {
        Day23 test=new Day23();
        System.out.println(test.letterCombinations1("23"));
    }
}
