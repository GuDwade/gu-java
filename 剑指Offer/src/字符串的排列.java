import java.util.*;

public class 字符串的排列 {
    List<String>ret=new ArrayList<>();
    public String[] permutation(String s) {
        StringBuilder sb=new StringBuilder();
        char[]chars=s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];
        dfs(chars,0,sb,used);
        String[]arr=ret.toArray(new String[]{});
        return  arr;
    }

    private void dfs(char[] chars, int count, StringBuilder sb,boolean[]used) {
        if(count==chars.length){
            if (!ret.contains(sb.toString())){
                ret.add(sb.toString());
            }
            return;
        }

        for(int i=0;i<chars.length;i++){
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            sb.append(chars[i]);
            count++;
            used[i] = true;
            dfs(chars, count, sb,used);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
            count--;
        }

    }


    public static void main(String[] args) {
        字符串的排列 test=new 字符串的排列();
        System.out.println(Arrays.toString(test.permutation("baca")));
    }
}
