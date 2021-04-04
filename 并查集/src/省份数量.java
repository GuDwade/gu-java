public class 省份数量 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++){
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        return  uf.getCount();
    }

}
