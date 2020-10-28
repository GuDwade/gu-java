package Dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day28 {
    //独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Set<Integer> set=new HashSet<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if (set.contains(entry.getValue())){
                return  false;
            }
            set.add(entry.getValue());
        }

        return  true;
    }
}
