package Dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day22 {
	//划分字母区间
    public static List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map=new HashMap<>();
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }

        int end=0,start=0;

        for(int i=0;i<S.length();i++){
            end=Math.max(end,map.get(S.charAt(i)));
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }

        return  res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
