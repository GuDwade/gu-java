package July;

public class Day26 {
    // 魔术索引
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if (nums[i]==i){
                return  i;
            }
            if (nums[i]>i){
                i=nums[i]-1;
            }
        }
        return  -1;
    }
}
