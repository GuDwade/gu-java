import java.util.HashMap;
import java.util.Map;

public class Pratices {
    //回文排列
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            Integer count=map.get(c);
            if(count==null){
                map.put(c,1);
            }
            if(count==1){
                map.remove(c,1);
            }
        }
        return map.size()<=1;
    }
    //一次编辑
    public boolean oneEditAway(String first, String second) {
        int len=first.length()-second.length();
        if(len>1||len<-1){
            return  false;
        }
        int start1=0;
        int start2=0;
        int count=1;
        while(start1<first.length()&&start2<second.length()){
            if(first.charAt(start1)!=second.charAt(start2)){
                if(len==1){
                    //删掉了一个字符  start2跳过删掉的字符到了下一个字符 相当于start2多走一步
                    start2--;
                }
                if(len==-1){
                    //增加了一个字符  相当与start1多走一步
                    start1--;

                }
                count--;
                if(count<0){
                    return  false;
                }
            }
            start1++;
            start2++;
        }
        return  true;
    }
}
