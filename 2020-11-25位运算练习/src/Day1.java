import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
    public int countPrimeSetBits(int L, int R) {
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            if (isSuShu(countOne(i))){
                cnt++;
            }
        }
        return  cnt;
    }

    private boolean isSuShu(int i) {
        if (i == 1){
            return  false;
        }

        if (i <= 3){
            return  true;
        }

        for(int j = 2; j <= i /2; j++){
            if (i % j == 0) {
                return  false;
            }
        }

        return  true;
    }

    private int countOne(int i) {
        int cnt = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                cnt++;
            }
            i >>= 1;
        }

        return  cnt;
    }

    public static int countPrimeSetBits1(int L, int R) {
        Set<Integer> set = new HashSet<>();
        Integer[] primes ={2,3,5,7,11,13,17,19};
        set.addAll(Arrays.asList(primes));

        int cnt = 0;
        for(int i = L; i <= R; i++) {
            int num = 0;
            for(int j = i; j > 0; j >>= 1) {
                num += (j & 1);
            }
            if (set.contains(num)){
                cnt++;
            }
        }

        return  cnt;
    }

    public static int findComplement(int num) {
        int ret = 0;
        int fac = 0; // 标记是第几位

        while (num > 0) {
            if ((num & 1) == 0){
                ret += 1 << fac;
            }
            num >>= 1;
            fac++;
        }

        return  ret;
    }


    public static void main(String[] args) {
        System.out.println(countPrimeSetBits1(842, 888));
        System.out.println(findComplement(5));
    }
}
