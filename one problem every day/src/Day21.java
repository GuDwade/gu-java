import java.util.HashMap;
import java.util.Map;

public class Day21 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:deck){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int x=-1;
        for(int num:map.values()){
            x=x==-1?num:gcd(num,x);
            if(x==1) {
                return false;
            }
        }
        return true;
    }
    private int  gcd(int x,int y){
        return  x%y==0?y:gcd(y,x%y);
    }
}
