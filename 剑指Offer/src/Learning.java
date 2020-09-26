public class Learning {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ret=dfs(nums,l,r,target);
        return  ret;
    }

    private int dfs(int[] nums, int l, int r, int target) {
        while (l<=r){
            int mid=l+r>>1;
            if (nums[mid]==target){
                return 1+dfs(nums, l, mid-1, target)+dfs(nums, mid+1, r, target);
            }else if (nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }

        }
        return 0;
    }

    public int missingNumber(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]==mid){
                l=mid+1;
            }else{
                r=mid;
            }
        }

        return  l;
    }

    public String reverseLeftWords(String s, int n) {
        int sz=s.length();
        int k=n%sz;
        StringBuilder sb=new StringBuilder();
        sb.append(s.substring(k));
        sb.append(s.substring(0,k));
        return  sb.toString();
    }

    public static void main(String[] args) {
        Learning test=new Learning();
        System.out.println(test.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
