public class 数组中的逆序对 {

    public static int reversePairs(int[] nums) {
        int[] helper = new int[nums.length];
        int ret = merge(nums,0,nums.length - 1,helper);
        return  ret;
    }

    private static int merge(int[]nums,int l, int r, int[] helper) {
        if (l >= r){
            return  0;
        }

        int mid = (l + r) >> 1;
        int ret = merge(nums,l, mid,helper) +merge(nums,mid + 1,r,helper);
        int i = l , j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r){
            if (nums[i] <= nums[j]){
                helper[idx++] = nums[i++];
            }else{
                helper[idx++] = nums[j++];
                ret += mid - i + 1;
            }
        }

        while (i <= mid){
            helper[idx++] = nums[i++];
        }

        while (j <= r ){
            helper[idx++] = nums[j++];
        }

        for(int k = l; k <= r; k++ ){
            nums[k] = helper[k];
        }

        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }
}
