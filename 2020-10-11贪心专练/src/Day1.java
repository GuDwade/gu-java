import java.util.Arrays;

public class Day1 {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        //优先找10块的
        int fives=0,tens=0;
        for(int b:bills){
            if (b==5){
                fives++;
            }else if (b==10){
                if (fives>0){
                    fives--;
                    tens++;
                }else{
                    return  false;
                }
            }else{
                int x=15;
                if (tens>0){
                    x-=10;
                    tens--;
                }
                while (x>0&&fives>0){
                    x-=5;
                    fives--;
                }
                if (x>0){
                    return  false;
                }
            }
        }

        return  true;
    }

    //判断子序列
    public boolean isSubsequence(String s, String t) {
        int i=0;
        for(int j=0;j<t.length()&&i<s.length();j++){
            if (t.charAt(j)==s.charAt(i)){
                i++;
            }
        }
        return  i==s.length();
    }


    //分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0, ret=0;
        for(;i<g.length;i++){
            while (j<s.length&&s[j]<g[i]){
                j++;
            }
            if (j<s.length){
                j++;
                ret++;
            }
        }
        return  ret;
    }
}
