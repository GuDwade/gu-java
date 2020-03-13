import java.util.*;

public class Day8 {
    //多数元素
    //每个数组最多只有一个多数
    public int majorityElement(int[] nums) {
        int times=nums.length/2;
        int i;
        for(i=0;i<nums.length-1;i++){
            int count=1;
            for(int j=i+1;i<nums.length;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
                if (count>times){
                    break;
                }
            }
            if(count>times){
                break;
            }
        }
        return nums[i];
    }
    public int majorityElement1(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        List<Integer>list=new ArrayList<>(set);
        int i;
        for(i=0;i<list.size();i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==list.get(i)){
                    count++;
                }
                if (count>nums.length/2){
                    break;
                }
            }
            if (count>nums.length/2){
                break;
            }
        }
        return list.get(i);
    }

    //摩尔投票法  一换一
    public int majorityElement2(int[] nums) {
        int val=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if (nums[i]==val){
                count++;
            }else{
                count--;
                if (count==0){
                    val=nums[i+1];
                }
            }
        }
        return val;
    }
}
