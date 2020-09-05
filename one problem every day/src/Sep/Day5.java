package Sep;

public class Day5 {
    String ret;
    int cnt;
    public String getPermutation(int n, int k) {
        int []nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        boolean[]isUsed=new boolean[n];
        StringBuilder sb=new StringBuilder();
        dfs(nums,isUsed,n,k,sb);
        return ret;
    }

    private void dfs(int[] nums, boolean[] isUsed, int n,int k, StringBuilder sb) {
        if(sb.length()==n){
            cnt++;
            if (cnt==k){
                ret=sb.toString();
            }
            return;
        }

        for(int i=0;i<n;i++){
            if (isUsed[i]){
                continue;
            }
            isUsed[i]=true;
            sb.append(nums[i]);
            dfs(nums, isUsed, n, k, sb);
            isUsed[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Day5 test=new Day5();
        System.out.println(test.getPermutation(4, 9));
    }
}
