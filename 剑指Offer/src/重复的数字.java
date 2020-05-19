public class 重复的数字 {

    //找出数组中重复的数字
    public int duplicateInArray(int[] nums) {
        int len=nums.length;
        for(int n:nums){
            if(n<0||n>=len){
                return -1;
            }
        }

        for(int i=0;i<len;i++){
            while (nums[nums[i]] != nums[i]){
                //每交换一次 把一个数放到它的正确位置上
                swap(nums,i,nums[i]);
            }
            if(nums[i]!=i){
                return nums[i];
            }
        }

        return -1;
    }


    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    //不修改数组找出重复的数字
    public int duplicateInArray1(int[] nums) {
        int left=1,right=nums.length-1;
        while (left<right){
            int mid=left+right>>1;
            int count=0;
            for(int n:nums){
                if(n>=left&&n<=mid){
                    count++;
                }
            }
            if (count>mid-left+1){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        重复的数字 n=new 重复的数字();
        int[]nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int[]nums1={0,5,2,3,1,4};
        System.out.println(n.duplicateInArray(nums));
        System.out.println(n.duplicateInArray(nums1));
    }
}
