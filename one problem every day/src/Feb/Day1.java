package Feb;

import java.util.HashSet;
import java.util.Set;

public class Day1 {
    // 公平的糖果棒交换
    // sumA - x + y  = sumB + x - y
    //  x = (sumA - sumB)/2 + y
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for(int x : A){
            sumA += x;
        }
        int sumB = 0;
        for(int x :B){
            sumB += x;
        }

        Set<Integer> set = new HashSet<>();
        for(int x : A){
            set.add(x);
        }

        int[] ret = {-1,-1};
        int k = sumA - sumB >> 1;
        for(int y : B){
          int x = k + y;
          if (set.contains(x)){
              ret[0] = x;
              ret[1] = y;
              break;
          }
        }


        return  ret;
    }
}
