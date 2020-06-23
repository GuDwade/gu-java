package June;

public class Day16 {
    //最接近的三数之和
    int min=Integer.MAX_VALUE;
    int ret=0;
    public int threeSumClosest(int[] nums, int target) {
        dfs(nums,target,0,0,0);
        return ret;
    }

    private void dfs(int[] nums, int target, int count, int sum, int idx) {
        if(count==3){
            if(Math.abs(sum-target)<min){
                min=Math.abs(sum-target);
                ret=sum;
            }

            return;
        }

        for(int i=idx;i<nums.length;i++){
            sum+=nums[i];
            count++;
            dfs(nums,target,count,sum,i+1);
            sum-=nums[i];
            count--;
        }
    }

    public static void main(String[] args) {
        Day16 test=new Day16();
        System.out.println(test.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
