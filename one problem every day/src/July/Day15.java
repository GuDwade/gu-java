package July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {

    //两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:nums1){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            Integer count=map.get(nums2[i]);
            if(count != null && count != 0){
                list.add(nums2[i]);
                map.put(nums2[i],count-1);
            }
        }

        int[]ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return  ret;
    }
}
