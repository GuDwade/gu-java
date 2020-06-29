package June;

import java.util.Arrays;

public class Day22 {
    //数组中的第K个最大元素
    //堆排序
    public void downShift(int[]nums,int idx,int len){
        int left=idx*2+1;
        while (left<len){
            int max=left;
            int right=idx*2+2;
            if(right<len&&nums[right]>nums[max]){
                max=right;
            }
            if (nums[idx]>nums[max]){
                break;
            }
            swap(nums,idx,max);
            idx=max;
            left=idx*2+1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        for(int i=len-2/2;i>=0;i--){
            downShift(nums,i,len);
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<k;i++){
            swap(nums,0,len-1-i);
            downShift(nums,0,len-1-i);
        }

        return  nums[len-k];
    }

    public static void main(String[] args) {
        Day22 test=new Day22();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 4, 6}, 2));
    }
}
