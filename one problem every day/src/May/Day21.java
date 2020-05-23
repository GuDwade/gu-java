package May;

import java.util.HashMap;
import java.util.Map;

public class Day21 {
    //最小覆盖子串
    public String minWindow(String s, String t) {
        if (s.equals(t)){
            return s;
        }
        if (s.length()<t.length()||!isRebuild(s,t)){
            return "";
        }
        int sz=t.length();
        String ret=s;
        for(int i=0;i<=s.length()-sz;i++){
            for(int j=i+sz-1;j<s.length();j++){
                String tmp=s.substring(i,j+1);
                if (isRebuild(tmp,t)&&tmp.length()<ret.length()){
                    ret=tmp;
                    break;
                }
            }
        }
        return ret;

    }


    public boolean isRebuild(String sub,String t){
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:sub.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0).intValue() + 1);
        }
        for(char ch:t.toCharArray()){
            Integer cnt=map.get(ch);
            if(cnt==null||cnt.equals(0)){
                    return false;
            }
            map.put(ch,cnt-1);
        }
        return  true;
    }

    public static void main(String[] args) {
        Day21 test=new Day21();
        System.out.println(test.minWindow("abc", "ac"));
    }
}
