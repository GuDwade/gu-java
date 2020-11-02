package Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

    //两个数组的交集

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null){
            return  new int[]{};
        }
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]==nums2[j]){
                if(ret.isEmpty()||nums1[i]!=ret.get(ret.size()-1)){
                    ret.add(nums1[i]);
                }
                i++;
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }

        int [] rets=new int[ret.size()];
        for(int k=0;k<rets.length;k++){
            rets[k]=ret.get(k);
        }
        return  rets;
    }
}
