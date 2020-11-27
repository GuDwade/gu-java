package Nov;

import java.util.HashMap;

public class Day27 {
    // 四数相加 II
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = A[i];
            for(int j = 0; j < n; j++) {
                int tar = num + B[j];
                map.put(tar,map.getOrDefault(tar,0)+1);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int num = C[i];
            for(int j = 0; j < n; j++) {
                int tar = num + D[j];
                if (map.containsKey(-tar)){
                    cnt += map.get(-tar);
                }
            }
        }
        return  cnt;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
