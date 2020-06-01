package June;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    //拥有最多糖果的孩子
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=-1;
        for(int can:candies){
            if(can>max){
                max=can;
            }
        }

        List<Boolean>ret=new ArrayList<>();
        for(int can:candies){
            if (can+extraCandies>=max){
                ret.add(true);
            }else{
                ret.add(false);
            }
        }
        return  ret;
    }
}
