public class 移除最多的同行或同列石头 {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(uf.isConnected(i, j)){
                    continue;
                }
                int x1 = stones[i][0];
                int y1 = stones[i][1];

                int x2 = stones[j][0];
                int y2 = stones[j][1];

                if (x1 == x2 || y1 == y2){
                    uf.union(i,j);
                }
            }
        }

        return  n - uf.getCount();
    }
}
