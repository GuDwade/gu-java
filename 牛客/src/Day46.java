import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Day46 {
    //多数
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:array){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer>en:map.entrySet()){
            if(en.getValue()>array.length/2){
                return en.getKey();
            }
        }
        return  0;
    }

    //简单错误记录
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Map<String,Integer>map=new LinkedHashMap<>();
        while (scan.hasNext()){
            String name=scan.next();
            int row=scan.nextInt();
            String record=build(name,row);
            if(map.containsKey(record))
                map.put(record, map.get(record)+1);
            else {
                map.put(record, 1);
            }
        }
        int count=0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.size()-8)){
                System.out.println(string+" "+map.get(string));
            }
        }

    }

    private static String build(String name, int row) {
        StringBuilder sb=new StringBuilder();
        int idx=name.length()-1;
        while (idx>=0&&name.charAt(idx)!='\\'){
            idx--;
        }
        String record=name.substring(idx+1);
        if(record.length()>16){
            record=record.substring(record.length()-16);
        }
        sb.append(record+' ');
        sb.append(row);
        return sb.toString();

    }
}
