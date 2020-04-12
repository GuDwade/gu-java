import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class April_7th {
    public int getKthMagicNumber(int k) {
        long[]prime={3,5,7};
        Queue<Long>queue=new PriorityQueue<>();
        Set<Long>set=new HashSet<>();
        queue.offer(1L);
        long min=1;
        for (int i=0;i<k;i++){
             min=queue.poll();
            for(long num:prime){
                if(!set.contains(min*num)){
                    set.add(min*num);
                    queue.offer(min*num);
                }
            }
        }
       return (int)min;
    }
}
