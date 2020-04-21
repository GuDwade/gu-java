public class Day45 {
    //优美子数组
    /*
    不断右移 right 指针来扩大滑动窗口，使其包含 k 个奇数；

    若当前滑动窗口包含了 k 个奇数，则如下「计算当前窗口的优美子数组个数」：

    统计第 1 个奇数左边的偶数个数 leftEvenCnt。 此处的偶数都是连续的
    统计第 k 个奇数右边的偶数个数 rightEvenCnt。
   因此「优美子数组」左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)

     */
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0,right=0,oddCount=0,res=0;

        while (right<nums.length){
            if((nums[right++]&1)==1){
                oddCount++;
            }
            if(oddCount==k){
                int tmp=right;
                while(right<nums.length&&(nums[right]&1)==0){
                    right++;
                }
                int rightEvent=right-tmp;

                int leftEvent=0;
                while ((nums[left]&1)==0){
                    leftEvent++;
                    left++;
                }

                res+=(leftEvent+1)*(rightEvent+1);

                left++;
                oddCount--;
            }
        }

        return  res;
    }

}
