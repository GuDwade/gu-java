import java.util.LinkedList;
import java.util.Queue;


public class RecentCounter {
    Queue<Integer>que;
    public RecentCounter() {
        que=new LinkedList();
    }

    public int ping(int t) {
        que.add(t);
        while(que.peek()<t-3000){
            que.poll();
        }
        return que.size();
    }

    public static void main(String[] args) {
        RecentCounter recen=new RecentCounter();
        System.out.println(recen.ping(1));  //1
        System.out.println(recen.ping(300));//2
        System.out.println(recen.ping(3001));//3
        System.out.println(recen.ping(3002));//3
        System.out.println(recen.ping(3301));//3
    }
}
