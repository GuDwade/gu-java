package Feb;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day7 {

    //检查数组是否经排序和轮转得到
    public static boolean check(int[] nums) {
        if (nums.length <= 2){
            return  true;
        }

        int  i = 1;
        int len = nums.length;
        while (i < len ){
            if (nums[i] >= nums[i - 1]){
                i++;
            }else{
                break;
            }
        }

        if (i == len ){
            return  true;
        }

        int j = i + 1;
        while (j < len){
            if (nums[j] >= nums[j - 1]){
                j++;
            }else{
                return  false;
            }
        }

        return nums[len - 1] <= nums[0] ? true : false;


    }

    public static boolean check1(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if (Arrays.equals(copy,nums)){
                return  true;
            }
            int cur = nums[0];
            for(int j = 0; j < n - 1; j++){
                nums[j] = nums[j + 1];
            }
            nums[n - 1] = cur;
        }
        return  false;
    }

    //移除石子的最大得分
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        int x = 0;

        if (arr[0] + arr[1] < arr[2]){
            x = arr[2] - arr[1] -arr[0];
        }else{
            x = sum % 2;
        }

        return  sum - x >> 1;
    }

    public int maximumScore1(int a, int b, int c) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.offer(a);
        queue.offer(b);
        queue.offer(c);

        int cnt = 0;

        while (queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();

            cnt++;

            if (--first > 0){
                queue.offer(first);
            }

            if (--second > 0){
                queue.offer(second);
            }
        }

        return  cnt;
    }

    // 非递减数列
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return true;
        }

        int cnt = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                if(i == 1 || nums[i] >= nums[i - 2]){
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = nums[i -1];
                }
                if(++cnt > 1){
                    return false;
                }
            }


        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check1(new int[]{3, 4, 5, 1, 2}));
    }
    
}
