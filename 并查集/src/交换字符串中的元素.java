import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class 交换字符串中的元素 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionFind uf = new UnionFind(len);

        for(List<Integer> list : pairs){
            uf.union(list.get(0),list.get(1));
        }

        //  以Integer为根的集合
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < len; i++){
            int root = uf.find(i);
            if (map.containsKey(root)){
                map.get(root).add(chars[i]);
            }else{
                PriorityQueue<Character> pm = new PriorityQueue<>();
                pm.add(chars[i]);
                map.put(root,pm);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            int root = uf.find(i);
            sb.append(map.get(root).poll());
        }

        return  sb.toString();
    }


    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind(26);
        int len = A.length();

        for(int i = 0; i < len; i++){
            int x = A.charAt(i) - 'a';
            int y = B.charAt(i) - 'a';
            uf.union(x,y);
        }

        //  A = "leetcode", B = "programs", S = "sourcecode"
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int x = A.charAt(i) - 'a';
            int y = B.charAt(i) - 'a';

            int root = uf.find(x);

            if (map.containsKey(root)){
                if (!map.get(root).contains(A.charAt(i))){
                    map.get(root).add(A.charAt(i));
                }

                if (!map.get(root).contains(B.charAt(i))){
                    map.get(root).add(B.charAt(i));
                }
            }else{
                PriorityQueue<Character> pm = new PriorityQueue<>();
                pm.add(A.charAt(i));
                pm.add(B.charAt(i));
                map.put(root,pm);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            int x = S.charAt(i) - 'a';
            int root = uf.find(x);

            if (!map.containsKey(root)){
                sb.append(S.charAt(i));
            }else{
                sb.append(map.get(root).peek());
            }

        }

        return  sb.toString();
    }
}
