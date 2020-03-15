import java.util.HashMap;
import java.util.Map;
public class Test {
    //判定字符是否唯一
    public boolean isUnique(String astr) {
        Map<Character,Integer> map=new HashMap<>();
        char[]chars=astr.toCharArray();
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])>1){
                return false;
            }
        }
        return  true;
    }
    public boolean isUnique1(String astr){
        for(int i=0;i<astr.length()-1;i++){
            char value=astr.charAt(i);
            for(int j=i+1;j<astr.length();j++){
                if(astr.charAt(j)==value){
                    return false;
                }
            }
        }
        return true;
    }
    //判定是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return  false;
        }
        Map<Character,Integer>map=new HashMap<>();
        char[]chars1=s1.toCharArray();
        for(char c:chars1){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s2.length();i++){
            Integer count=map.get(s2.charAt(i));
            if(count==null||count==0){
                return  false;
            }
            map.put(s2.charAt(i),count-1);
        }
        return true;
    }
    //
    public String replaceSpaces(String S, int length) {
        String str=S.substring(0,length);
        return str.replace(" ","%20");
    }
    public String replaceSpaces1(String S, int length) {
        int count=0;
        for(int i=0;i<length;i++){
            if(S.charAt(i)==' '){
                count++;
            }
        }
        char[]build=new char[length+2*count];
        int i=0;
        for(int j=0;j<length;j++){
            if(S.charAt(j)==' '){
                build[i++]='%';
                build[i++]='2';
                build[i++]='0';
            }else{
                build[i++]=S.charAt(j);
            }
        }
        return new String(build);
    }
}
