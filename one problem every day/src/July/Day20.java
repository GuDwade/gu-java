package July;

public class Day20 {
    //两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        int[]ret={-1,-1};
        int left=0;
        int right=numbers.length-1;
        while (left<right){
            int sum=numbers[left]+numbers[right];
            if (sum==target){
                ret[0]=left+1;
                ret[1]=right+1;
                break;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return  ret;
    }
}
