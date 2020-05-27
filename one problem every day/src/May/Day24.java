package May;

import java.util.HashMap;
import java.util.Map;

public class Day24 {
    //和可被 K 整除的子数组
    public int subarraysDivByK(int[] A, int K) {
        int count=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            for(int j=i;j<A.length;j++){
                sum+=A[j];
                if(sum%K==0){
                    count++;
                }
            }
        }
        return  count;
    }


    public int subarraysDivByK1(int[] A, int K) {
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int a : A) {
            map.put((a % K + K) % K, map.getOrDefault((a % K + K) % K, 0) + 1);
        }
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key) * (map.get(key) - 1) / 2;
        }
        return sum;
    }
}
