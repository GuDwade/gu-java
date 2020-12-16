package December;

import java.util.HashMap;
import java.util.Map;

public class Day16 {
    //单词规律
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()){
            return  false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            if (!map.containsKey(cur)) {
                if (map.containsValue(strs[i])){
                    return  false;
                }
                map.put(cur , strs[i]);
            }else{
                if (!map.get(cur).equals(strs[i])){
                    return  false;
                }
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba",
                "dog cat cat fish"));
    }
}
