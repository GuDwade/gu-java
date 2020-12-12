package December;

public class Day11 {
    //摆动序列
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return  n;
        }

        int[] up = new int[n];
        int[] down = new int[n];

        up[0] = 1 ;
        down[0] = 1;

        for(int i = 1; i < n; i++){
            int prev = nums[i-1] , cur = nums[i];
            if (cur < prev){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else if (cur > prev){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return  Math.max(down[n-1],up[n-1]);
    }
}
