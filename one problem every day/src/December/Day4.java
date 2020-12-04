package December;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Day4 {
    //分割数组为连续子序列
    public static boolean isPossible(int[] nums) {
       Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
       for(int x : nums){
           if (!map.containsKey(x)) {
               map.put(x,new PriorityQueue<Integer>());
           }

           if (map.containsKey(x-1)){
                int preLen = map.get(x-1).poll();
                if (map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(preLen+1);
           }else{
               map.get(x).offer(1);
           }
       }

        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = map.entrySet();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry :entries){
            PriorityQueue<Integer> queue= entry.getValue();
            for(int x :queue){
                if (x < 3) {
                    return  false;
                }
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }
}
