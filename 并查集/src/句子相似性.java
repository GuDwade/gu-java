import java.util.HashMap;
import java.util.List;

public class 句子相似性 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        int len1 = words1.length;
        int len2 = words2.length;
        if (len1 != len2){
            return  false;
        }

        int n = pairs.size();
        int idx = 0;
        // 构造每个单词与idx的映射
        HashMap<String ,Integer> map = new HashMap<>(n * 2);
        for(List<String> pair : pairs){
            String str1 = pair.get(0);
            String str2 = pair.get(1);

            if (!map.containsKey(str1)){
                map.put(str1,idx);
                idx++;
            }

            if (!map.containsKey(str2)){
                map.put(str2,idx);
                idx++;
            }
        }

        UnionFind uf = new UnionFind(idx);
        for(List<String> pair : pairs){
            String str1 = pair.get(0);
            String str2 = pair.get(1);

           int x = map.get(str1);
           int y = map.get(str2);
           uf.union(x,y);
        }

        for (int i = 0; i < len1; i++){
            String str1 = words1[i];
            String str2 = words2[i];

            if (str1.equals(str2)){
                continue;
            }

            Integer x = map.get(str1);
            Integer y = map.get(str2);

            if (x == null || y == null){
                return  false;
            }

            if (!uf.isConnected(x,y)){
                return  false;
            }
        }

        return  true;

    }
}
