package December;

import java.util.*;

public class Day14 {
    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return  new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String cur = new String(chars);
            if (!map.containsKey(cur)){
                map.put(cur,new ArrayList<>());
            }
            map.get(cur).add(str);
        }

        List<List<String>> ret = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for(Map.Entry<String, List<String>> entry : entries){
            ret.add(entry.getValue());
        }
        return  ret;

    }
}
