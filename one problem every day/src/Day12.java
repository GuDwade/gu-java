import java.util.Arrays;

public class Day12 {
    public int countCharacters(String[] words, String chars) {
        int[]charsCount=new int[26];
        Arrays.fill(charsCount,0);
        for(char ch:chars.toCharArray()){
            //记录单词中每个字母的次数
            charsCount[ch-'a']++;
        }
        int len=0;
        for(String word:words){
            int []wordCount=new int[26];
            Arrays.fill(wordCount,0);
            for(char ch:word.toCharArray()){
                //记录单词中每个字母的次数
                wordCount[ch-'a']++;
            }
            boolean flag=true;
            for(char en:word.toCharArray()){
                //比较两个单词中字母出现次数
                if(wordCount[en-'a']>charsCount[en-'a']){
                    flag=false;
                    break;
                }
            }
            if(flag){
                len+=word.length();
            }
        }
        return  len;
    }
}
