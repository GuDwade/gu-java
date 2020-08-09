import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Aug_8th {
    //第 k 个缺失的正整数
    public int findKthPositive(int[] arr, int k) {
        int[] miss=new int[k];
        int idx=0;
        int cur=0;
        int num=1;
        while (cur<arr.length&&idx<k){
            if (arr[cur]==num){
                cur++;
            }else{
                miss[idx++]=num;
            }
            num++;
        }
        while (idx<k){
            miss[idx++]=num++;
        }
        return miss[k-1];
    }
   //整理字符串
   public static String makeGood(String s) {
       Stack<Character> stack=new Stack<>();

       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if (c>='a'&&c<='z'){
              if (stack.isEmpty()){
                  stack.push(c);
              }else{
                  char prev=stack.peek();
                  if (prev==c-32){
                      stack.pop();
                  }else{
                      stack.push(c);
                  }
              }
           }
           if (c>='A'&&c<='Z'){
               if (stack.isEmpty()){
                   stack.push(c);
               }else{
                   char prev=stack.peek();
                   if (prev==c+32){
                       stack.pop();
                   }else{
                       stack.push(c);
                   }
               }
           }
       }
       StringBuilder sb=new StringBuilder();
       while (!stack.isEmpty()){
           sb.append(stack.pop());
       }
       return  sb.reverse().toString();

   }
   //找出第 N 个二进制字符串中的第 K 位
    public static char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder post=invert(sb.toString());
            sb.append(1);
            sb.append(post.reverse());
        }

        return sb.charAt(k-1);
    }

    private static StringBuilder invert(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if (c=='1'){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        return  sb;
    }
    //和为目标值的最大数目不重叠非空子数组数目
    public static int maxNonOverlapping(int[] nums, int target) {

        int n = nums.length;
        int[] dp = new int[n + 1];
        Map<Long, Integer> map = new HashMap(n + 1);
        map.put(0L, 0);
        long sum = 0;
        for(int i = 1; i <= n; i++){
            sum += nums[i - 1];
            Integer pre = map.get(sum - target);
            dp[i] = dp[i - 1];
            if(pre != null){
                dp[i] = Math.max(dp[i], dp[pre] + 1);
            }
            map.put(sum, i);
        }
        int ans = dp[n];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
        findKthBit(3,1);
        System.out.println(maxNonOverlapping(new int[]{0,0,0}, 0));
    }
}
