public class 无向图中连通分量的数目 {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }

        return  uf.getCount();
    }
}
