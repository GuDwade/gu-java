package Dec;

import java.util.ArrayList;
import java.util.List;

public class Day14 {
    //查找常用字符

    public static List<String> commonChars(String[] A) {
        List<String>ret=new ArrayList<>();
        if(A==null||A.length==0){
            return  ret;
        }

        int []letters=new int[26];
        for(char c:A[0].toCharArray()){
            letters[c-'a']++;
        }

        for(int i=1;i<A.length;i++){
            int[]cur =new int[26];
            for(char c:A[i].toCharArray()){
                cur[c-'a']++;
            }

            for(int j=0;j<26;j++){
                letters[j]=Math.min(letters[j],cur[j]);
            }
        }

        for(int i=0;i<26;i++){
            while (letters[i]>0){
                ret.add((char)(i+'a')+"");
                letters[i]--;
            }
        }
        return  ret;
    }

    public static void main(String[] args) {
        List<String>list=commonChars(new String[]{"bella","label","roller"});
        for(String s:list){
            System.out.println(s+" ");
        }
    }
}
