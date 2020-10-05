package Dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {
    List<List<Integer>>ret;
    List<Integer>path;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ret=new ArrayList<>();
        path=new ArrayList<>();
        boolean[]isUesd=new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,0,target,isUesd);
        return  ret;
    }

    private void dfs(int[] nums, int idx, int cnt, int target,boolean[]isUesd) {
        if (cnt==4){
            if (target==0){
                ret.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if (isUesd[i]){
                continue;
            }

            if (i>=1&&nums[i-1]==nums[i]&&isUesd[i-1]==false){
                continue;
            }

            isUesd[i]=true;
            path.add(nums[i]);
            dfs(nums, i+1, cnt+1, target-nums[i], isUesd);
            path.remove(path.size()-1);
            isUesd[i]=false;
        }
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>>ret=new ArrayList<>();
        if(nums==null||nums.length<4){
            return  ret;
        }
        int len=nums.length;
        Arrays.sort(nums);

        for(int i=0;i<len-3;i++){
            //去重
            if(i>=1&&nums[i-1]==nums[i]){
                continue;
            }

            //最小的四个数之和已经大于target，不可能再出现满足的数，结束循环
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }

            //当前元素加上最大的三个数，仍然小于target,当前元素做头结点不可能，跳过
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }

            for(int j=i+1;j<len-2;j++){
                //去重
                if(j>i+1&&nums[j-1]==nums[j]){
                    continue;
                }

                //同上
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) {
                    break;
                }

                if(nums[i]+nums[j]+nums[len-2]+nums[len-1]<target){
                    continue;
                }

                int l=j+1,r=len-1;
                while (l<r){
                    if (nums[i]+nums[j]+nums[l]+nums[r]==target){
                        ret.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                        while (l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                    }else if (nums[i]+nums[j]+nums[l]+nums[r]<target){
                        while (l<r&&nums[l]==nums[l+1]){
                            l++;
                        }
                        l++;
                    }else{
                        while (l<r&&nums[r]==nums[r-1]){
                            r--;
                        }
                        r--;
                    }
                }
            }
        }

        return  ret;
    }
    public static void main(String[] args) {
        Day5 test=new Day5();
        System.out.println(test.fourSum1(new int[]{-2, -1, 0, 0, 1, 2}, 0));
    }
}
