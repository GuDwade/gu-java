import java.util.Arrays;

public class Test {
    public static int minNum(String str){
        int[] arr = new int[26];
        //26个字母在str中出现的次数
        for (int i=0; i<str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                return arr[i];
                //返回最小字母出现次数
            }
        }
        return 0;
    }
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[]queNum=new int[queries.length];
        for(int i=0;i<queNum.length;i++){
            queNum[i]=minNum(queries[i]);
        }
        int[]worNum=new int[words.length];
        for(int i=0;i<worNum.length;i++){
            worNum[i]=minNum(words[i]);
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
    public static void main(String[] args) {
        System.out.println(minNum("aba"));
        String[]str1={"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[]str2={"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
        System.out.println(Arrays.toString(numSmallerByFrequency(str1,str2)));
    }

}
