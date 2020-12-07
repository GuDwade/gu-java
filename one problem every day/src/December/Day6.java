package December;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Day6 {
    //前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : entries) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new int[]{num,cnt});
            }else{
                if (queue.peek()[1] < cnt){
                    queue.poll();
                    queue.offer(new int[]{num,cnt});
                }
            }
        }

        int[] ret = new int[k];
        for(int i = k - 1; k >= 0; k--){
            ret[k] =queue.poll()[0];
        }

        return  ret;
    }
}
