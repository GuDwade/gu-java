package August;

import java.util.HashMap;
import java.util.Map;

public class Day24{
    //机器人能否返回原点
    public boolean judgeCircle(String moves) {
        if(moves==null||moves.length()==0){
            return true;
        }

        Map<Character,int[]>map=new HashMap<>();
        map.put('R',new int[]{0,-1});
        map.put('L',new int[]{0,1});
        map.put('U',new int[]{-1,0});
        map.put('D',new int[]{1,0});

        int x=0;
        int y=0;
        for(int i=0;i<moves.length();i++){
            int []dis=map.get(moves.charAt(i));
            x+=dis[0];
            y+=dis[1];
        }

        return x==0&&y==0;

    }
    public boolean judgeCircle1(String moves) {
        if(moves==null||moves.length()==0){
            return true;
        }
        if(moves.length()%2!=0){
            return false;
        }

        int row=0;
        int col=0;

        for(int i=0;i<moves.length();i++){
            char cur=moves.charAt(i);
            if(cur=='R'){
                row++;
            }else if(cur=='L'){
                row--;
            }else if(cur=='U'){
                col++;
            }else if(cur=='D'){
                col--;
            }
        }

        return row==0&&col==0;

    }

}
