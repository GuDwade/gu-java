import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围 {

    int[] dx = {0,1};
    int[] dy = {1,0};

    public int movingCount(int m, int n, int k) {
        if (k == 0){
            return  1;
        }

        Queue<int[]>queue = new LinkedList<>();
        boolean[][]visted = new boolean[m][n];
        visted[0][0] = true;
        queue.offer(new int[]{0,0});
        int ret = 1;

        while (!queue.isEmpty()){
            int[] plot = queue.poll();
            for(int i = 0; i < 2;i++ ){
                int newX = plot[0] + dx[i];
                int newY = plot[1] + dy[i];

                if (newX >= m || newY >= n || getSum(newX) + getSum(newY) > k || visted[newX][newY]){
                    continue;
                }
                queue.offer(new int[]{newX,newY});
                visted[newX][newY] = true;
                ret++;
            }
        }

        return  ret;

    }

    private int getSum(int sum) {
        int ret = 0;
        while (sum != 0){
            ret += sum % 10;
            sum /= 10;
        }
        return  ret;
    }

    public static void main(String[] args) {
        机器人的运动范围  test = new 机器人的运动范围();
        test.movingCount(1,2,1);


    }
}
