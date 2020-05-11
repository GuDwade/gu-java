import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problems {
    //字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String str:strs){
            char[]tmp=str.toCharArray();
            Arrays.sort(tmp);
            String key=new String(tmp);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>>res=new ArrayList<>();
        for(List<String>list:map.values()){
            res.add(list);
        }
        return  res;
    }

    //比较版本号

    public int compareVersion(String version1, String version2) {
        int i=0, j=0;
        while (i<version1.length()||j<version2.length()){
            int x=i,y=j;
            while (x<version1.length()&&version1.charAt(x)!='.'){
                x++;
            }
            while (y<version2.length()&&version2.charAt(y)!='.'){
                y++;
            }
            //可能已经走完了
            //version1 = "1.0.1", version2 = "1"
            int a=i==x?0:Integer.valueOf(version1.substring(i,x));
            int b=j==y?0:Integer.valueOf(version2.substring(j,y));
            if (a<b){
                return  -1;
            }
            if(a>b){
                return 1;
            }
            i=x+1;
            j=y+1;
        }
        return  0;
    }
}
