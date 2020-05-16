package May;

public class Day15 {
    //和为K的子数组
    public int subarraySum(int[] nums, int k) {
        int ret=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    ret++;
                }
            }
        }
        return ret;
    }
}
