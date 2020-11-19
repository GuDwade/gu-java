package Nov;

import java.util.Arrays;

public class Day20 {
    public void moveZeroes(int[] nums) {
        int end = 0;
        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] != 0) {
                swap(nums,end,i);
                end++;
            }
        }

    }

    private void swap(int[] nums, int end, int i) {
        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        String[] arrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arrs,((o1, o2) ->{
            return (o2+o1).compareTo(o1+o2);
        } ));

        StringBuilder sb = new StringBuilder();
        for (String str : arrs){
            sb.append(str);
        }

        String ret = sb.toString();
        if (ret.charAt(0) == '0'){
            return  "0";
        }
        return  ret;
    }

    public int addDigits(int num) {
        if (num < 10) {
            return  num;
        }

        int sum = 0;
        while (num != 0){
            sum += (num % 10);
            num /= 10;
        }

        return  addDigits(sum);
    }
}
