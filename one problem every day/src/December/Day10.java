package December;

import java.util.LinkedList;
import java.util.Queue;

public class Day10{
    //  Dota2 参议院
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();
        for(int i =0; i < n; i++){
            char ch =senate.charAt(i);
            if (ch == 'R'){
                radiant.add(i);
            }else{
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.poll();
            int d = dire.poll();

            if(r < d){
                radiant.add(r + n);
            }else{
                dire.add(r + n);
            }
        }

        return  radiant.isEmpty() ? "Dire" : "Radiant";
    }
}