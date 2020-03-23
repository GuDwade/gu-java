import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumSmallerByFrequency {
    //比较字符串最小字母出现次数
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[]queNum=new int[queries.length];
        for(int i=0;i<queNum.length;i++){
            queNum[i]=minLettersNumber(queries[i]);
        }
        int[]worNum=new int[words.length];
        for(int i=0;i<worNum.length;i++){
            worNum[i]=minLettersNumber(words[i]);
        }
        int[]result=new int[queNum.length];
        for(int i=0;i<queNum.length;i++){
            int number=0;
            for(int j=0;j<worNum.length;j++){
                if(queNum[i]<worNum[j]){
                    number++;
                }
                result[i]=number;
            }
        }
        return  result;
    }
    public int minLettersNumber(String word){
        /*
        int[] arr = new int[26];
        for (int i=0; i<word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                return arr[i];
            }
        }
        return 0;
        */
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:word.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        char min=word.charAt(0);
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)<min){
                min=word.charAt(i);
            }
        }
        return map.get(min);
    }
    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int val:nums){
            if(set.contains(val)){
                return  true;
            }
            set.add(val);
        }
        return false;
    }
    //一段区间内存在重复元素
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
