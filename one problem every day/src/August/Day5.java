package August;

public class Day5 {
    //打家劫舍 III
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }

    //打家劫舍 II
    public int rob(int[] nums) {
        if (nums.length==0){
            return  0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int sz=nums.length;
        int[]front=new int[sz];
        int[]back=new int[sz];

        front[0]=nums[0];
        front[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<sz-1;i++){
            front[i]=Math.max(front[i-2]+nums[i],front[i-1]);
        }

        back[1]=nums[1];
        back[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<sz;i++){
            back[i]=Math.max(back[i-2]+nums[i],back[i-1]);
        }

        return Math.max(front[sz-2],back[sz-1]);
    }
}
