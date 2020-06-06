package June;

import java.util.HashSet;
import java.util.Set;

public class Day6 {
    //最长连续序列
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int len=0;
        for(int num:nums){
            if (!set.contains(num-1)){
                int cur=num;
                int curLen=1;
                while (set.contains(cur+1)){
                    cur+=1;
                    curLen++;
                }
                len=Math.max(len,curLen);
            }
        }
        return len;
    }
}
