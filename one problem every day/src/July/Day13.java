package July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    //计算右侧小于当前元素的个数
    //暴力超时
    public List<Integer> countSmaller1(int[] nums) {
        if(nums.length==0||nums==null){
            return new ArrayList<Integer>();
        }
        Integer[]ret=new Integer[nums.length];
        ret[nums.length-1]=0;
        for(int i=0;i<nums.length-1;i++){
            int val=nums[i];
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<val){
                    count++;
                }
            }
            ret[i]=count;
        }
        return Arrays.asList(ret);
    }

    private int[] temp;
    private int[] counter;
    private int[] indexes;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }


    private void mergeAndCountSmaller(int[] nums, int l, int r) {
        if (l == r) {
            // 数组只有一个元素的时候，没有比较，不统计
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        // 归并排序的优化，同样适用于该问题
        // 如果索引数组有序，就没有必要再继续计算了
        if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
        }
    }


    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
        for (int i = l; i <= r; i++) {
            temp[i] = indexes[i];
        }
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > r) {
                indexes[k] = temp[i];
                i++;

                counter[indexes[k]] += (r - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;

                counter[indexes[k]] += (j - mid - 1);
            } else {

                indexes[k] = temp[j];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        Day13 test=new Day13();
        test.countSmaller(new int[]{5,2,6,1});
    }
}
