import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Deque<Integer> max;
    Queue<Integer> que;
    public MaxQueue() {
        max=new LinkedList();
        que=new LinkedList();
    }

    public int max_value() {
        if(que.isEmpty()){
            return -1;
        }
        return max.peek();
    }

    public void push_back(int value) {
        que.offer(value);
        //使双端队列队头始终保持当前队列最大的值
        //单调递减排列
        while(!max.isEmpty()&&value>max.getLast()){
            max.pollLast();
        }
        max.offer(value);
    }

    public int pop_front() {
        if(que.isEmpty()){
            return -1;
        }
        int tmp=que.poll();
        if(tmp==max.getFirst()){
            max.poll();
        }
        return tmp;
    }
}
