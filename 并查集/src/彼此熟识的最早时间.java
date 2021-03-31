import java.util.Arrays;

public class 彼此熟识的最早时间 {

    public int earliestAcq(int[][] logs, int N) {
        UnionFind uf = new UnionFind(N);
        int time = -1;
        Arrays.sort(logs,((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        for(int[] log : logs){
            uf.union(log[1],log[2]);
            if (uf.getCount() == 1){
                time = log[0];
                break;
            }
        }

        return  time;

    }


}
