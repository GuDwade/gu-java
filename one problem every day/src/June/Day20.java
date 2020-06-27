package June;

public class Day20 {
    //缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将所有的负数变为 n+1 不会影响结果
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //将存在的数 按位置存储（将该位置的数变为负数）
        // 3  nums[3-1]=-nums[3-1] 即3是存在的
        // 如果某个位置>0 即这个位置没有改变 按顺序存储的这个数不存在 i+1;
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Day20 test=new Day20();
        int[]arr={3,4,-1,1};
        System.out.println(test.firstMissingPositive(arr));
    }
}
