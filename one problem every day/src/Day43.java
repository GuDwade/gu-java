import java.util.HashMap;
import java.util.Map;

public class Day43 {
    //统计重复个数
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length(), l2 = s2.length();
        int counts1 = 0, counts2 = 0;
        // 记录下一个要匹配的s2中字符的索引
        int index = 0;
        Map<Integer,int[]> map = new HashMap<>();
        while(counts1<n1){
            //在一个s1中搜索s2的结果，记录在hashmap中
            for(char c: c1){
                if(c==c2[index]){
                    index++;
                };
                if(index==l2){
                    index = 0;
                    counts2++;
                }
            }
            counts1++;
            //hashmap中存放p:{counts1,counts2}
            if(!map.containsKey(index)){
                map.put(index,new int[]{counts1,counts2});
            }else{  //表示当前搜索的结果在之前出现过，也就是出现了循环节
                int[] last = map.get(index);
                int circle1 = counts1-last[0];
                int circle2 = counts2-last[1];  //每circle1个s1可以得到circle2个s2
                counts2 += circle2*((n1-counts1)/circle1);  //根据循环跳到最后
                counts1 += circle1*((n1-counts1)/circle1);  //根据循环跳到最后
            }
        }
        return counts2/n2;
    }

    public static void main(String[] args) {
        int a=getMaxRepetitions("abaacdbac",100,"adcbd",4);
    }
}
