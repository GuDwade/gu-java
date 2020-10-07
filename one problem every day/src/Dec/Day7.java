package Dec;

public class Day7 {
    // 颜色分类

    //遍历数组两遍
    public void sortColors(int[] nums) {
        int end=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[end];
                nums[end]=tmp;
                end++;
            }
        }

        for(int i=end;i<nums.length;i++){
            if (nums[i]==1){
                int tmp=nums[i];
                nums[i]=nums[end];
                nums[end]=tmp;
                end++;
            }
        }

    }

    //双指针
    public static void sortColors1(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int i=0;    //i之前的元素全部遍历过了

        while (i<=r){
            if (nums[i]==0){
                swap(nums,i,l);
                i++;
                l++;
            }else if (nums[i]==1){
                i++;
            }else{
                swap(nums,i,r);//把后面的数交换到前面，后面的数之前没有遍历过，不用i++
                r--;
            }

        }

    }

    private static void swap(int[] nums, int i, int l) {
        int tmp=nums[i];
        nums[i]=nums[l];
        nums[l]=tmp;
    }

    public static void main(String[] args) {
        sortColors1(new int[]{2,0,2,1,1,0});
    }
}
