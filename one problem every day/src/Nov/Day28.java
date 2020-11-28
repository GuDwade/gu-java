package Nov;

public class Day28 {
    // 翻转对
    public static int reversePairs(int[] nums) {
        int[] helper = new int[nums.length];
        return  mergePairs(nums,helper,0,nums.length-1);
    }

    private static int mergePairs(int[] nums, int[] helper, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + r >> 1;
        int ret = mergePairs(nums,helper,l,mid) + mergePairs(nums, helper, mid+1, r);
        int i = l ,j = mid + 1, idx = l;
        while (i <= mid && j <= r){
            if (nums[i] < nums[j]){
                helper[idx++] = nums[i++];
            }else if (nums[i] == nums[j]){
                if (nums[i] < 0){
                    int cur = j ;
                    while (cur <= r -1 && nums[cur] == nums[cur + 1]){
                        cur++;
                    }
                    ret += cur - j +1;
                }
                helper[idx++] =nums[i++];
            }else{
                int cur = i;
                while (cur <= mid && (long)nums[cur] <= (long) 2 * nums[j]){
                    cur++;
                }
                ret += mid - cur +1;
                helper[idx++] = nums[j++];
            }
        }
        while (i <= mid){
            helper[idx++] = nums[i++];
        }

        while (j <= r){
            helper[idx++] = nums[j++];
        }

        for(int k = l;  k <= r; k++){
            nums[k] =helper[k];
        }
        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
