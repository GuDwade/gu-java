package Nov;

public class Day19 {

    //加油站

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;

        while (i < n){
            int own = 0 , needs = 0;
            int cnt = 0;

            while (cnt < n){
                int idx = (i+cnt) % n ;
                own += gas[idx];
                needs += cost[idx];
                if (needs > own){
                    break;
                }
                cnt++;
            }

            if (cnt == n){
                return  i;
            }else{
                i += cnt + 1;
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
