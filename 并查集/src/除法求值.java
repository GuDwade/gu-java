import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 除法求值 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        UnionFind uf = new UnionFind(n * 2);
        HashMap<String,Integer> map = new HashMap<>(n * 2);
        int idx = 0;

        for(int i = 0; i < n; i++){
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);

            if (!map.containsKey(str1)){
                map.put(str1,idx);
                idx++;
            }

            if (!map.containsKey(str2)){
                map.put(str2,idx);
                idx++;
            }

            uf.union(map.get(str1),map.get(str2),values[i]);


        }

        int m = queries.size();
        double[] rets = new double[m];
        for (int i = 0; i < m; i++){
            Integer idx1 = map.get(queries.get(i).get(0));
            Integer idx2 = map.get(queries.get(i).get(1));

            if (idx1 == null || idx2 == null){
                rets[i] = -1.0d;
            }else {
                rets[i] = uf.isConnected(idx1,idx2);
            }
        }


        return  rets;

    }


    class UnionFind {

        private int[] parent;
        private double[] weights;

        // 连通分量 （独立集合的个数）
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            weights = new double[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                weights[i] = 1.0d;
            }
        }

        public int find(int x){
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weights[x] *= weights[origin];
            }
            return parent[x];
        }



        public void union(int x, int y,double value){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY){
                return;
            }

            parent[rootX] = rootY;
            weights[rootX] = weights[y] * value / weights[x];
        }

        public  int getCount(){
            return  count;
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY){
                return weights[x] / weights[y];
            }else{
                return -1.0d;
            }

        }
    }


    public static void main(String[] args) {
        List<List<String>> ret = new ArrayList<>();
        String[] arr1 = {"a","b"};
        String[] arr2 = {"b","c"};

        ret.add(Arrays.asList(arr1));
        ret.add(Arrays.asList(arr2));

        double[] values = {2.0,3.0};


        String[] arr3 = {"a","c"};
        String[] arr4 = {"b","a"};
        String[] arr5 = {"a","e"};
        String[] arr6 = {"a","a"};

        List<List<String>> quaries = new ArrayList<>();
        quaries.add(Arrays.asList(arr3));
        quaries.add(Arrays.asList(arr4));
        quaries.add(Arrays.asList(arr5));
        quaries.add(Arrays.asList(arr6));

        除法求值  test = new 除法求值();
        test.calcEquation(ret,values,quaries);

    }
}



