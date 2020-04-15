
import java.util.HashMap;
import java.util.Map;

public class Test {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer>map1=new HashMap<>();
        for(char ch:s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        Map<Character,Integer>map2=new HashMap<>();
        for(char ch:t.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        char ret=0;
        for(char ch:t.toCharArray()){
            if(map1.get(ch)!=map2.get(ch)){
                ret=ch;
                break;
            }
        }
        return  ret;
    }

    public char findTheDifference1(String s, String t) {
        int sum1=0;
        for(char ch:s.toCharArray()){
            sum1+=ch;
        }

        int sum2=0;
        for(char ch:t.toCharArray()){
            sum2+=ch;
        }

        return (char)(sum2-sum1);
    }

    public int findMaxLength(int[] nums) {
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            int ones=0,zeros=0;
            for(int j=i;j<nums.length;j++){
                if (nums[j]==0){
                    zeros++;
                }
                if(nums[j]==1){
                    ones++;
                }
                if(ones==zeros){
                    maxLength=Math.max(maxLength,j-i+1);
                }
            }
        }
        return  maxLength;
    }
    //遇到了相同的 countcount 2 次  表示在（i,j]区间内0 和 1 的数目一样多
    public static int findMaxLength1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength1(new int[]{0,1,0,0,1,1,0}));
    }

}
