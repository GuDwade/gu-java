public class 连通网络的操作次数 {

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n - 1){
            return  -1;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] con : connections){
            uf.union(con[0],con[1]);
        }

        return uf.getCount() - 1;
    }
}
