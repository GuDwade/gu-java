public class Day41 {
    //跳跃游戏
    public boolean canJump(int[] nums) {

        int len=nums.length;
        if(len==1){
            return true;
        }
        //max表示能够到达的最大位置
        int max=0;
        for(int i=0;i<len-1;i++){
            if(i<=max){
                max=Math.max(max,i+nums[i]);
            }else{
                break;
            }
            if(max>=len-1){
                return true;
            }
        }
        return false;
    }
}
