import java.util.HashMap;
import java.util.Map;

public class Day10 {
    //同构字符串
    //输入: s = "egg", t = "add"
    //输出: true
    //输入: s = "foo", t = "bar"
    //输出: false
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return  false;
        }
        Map<Character,Character>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return  false;
                }
            }
        }
        return true;
    }
}