package August;

import java.util.ArrayList;
import java.util.List;

public class Day9 {
    //计数二进制子串
    public int countBinarySubstrings(String s) {
        List<Integer>list=new ArrayList<>();
        int cur=0;
        while(cur<s.length()){
            char c=s.charAt(cur);
            int count=0;
            while (cur<s.length()&&s.charAt(cur)==c){
                cur++;
                count++;
            }
            list.add(count);
        }
        int ret=0;
        for(int i=1;i<list.size();i++){
            ret+=Math.min(list.get(i-1),list.get(i));
        }
        return  ret;
    }
}
