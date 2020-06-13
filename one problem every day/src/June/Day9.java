package June;

import java.util.*;

public class Day9 {
    //三数之和
    List<List<Integer>>ret=new ArrayList<>();


    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,0,0,list);
        return  ret;
    }

    private void dfs(int[] nums, int idx, int count, int sum,List<Integer>list) {

        if(count==3&&sum==0){
            if (!ret.contains(list)){
                ret.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i=idx;i<nums.length&&count<=3;i++){
            list.add(nums[i]);
            sum+=nums[i];
            count++;
            dfs(nums,i+1,count,sum,list);
            sum-=nums[i];
            count--;
            list.remove(list.size()-1);
        }

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int left=i+1,right=nums.length-1,sum=0-nums[i];
                while(left<right){
                    if(nums[left]+nums[right]==sum){
                        ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]<sum){
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                    }else{
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }
            }

        }

        return  ret;

    }

    public static void main(String[] args) {
        Day9 test=new Day9();
        System.out.println(test.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
