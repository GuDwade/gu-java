import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("班级","11");
        map.put("学院","经管");
        map.put("专业","信管");
        map.put("学号","17050411103");
        map.put("姓名","顾富成");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        for(Map.Entry<String,String>entry:map.entrySet()){
            System.out.println(entry.getKey()+
                    "----->" +entry.getValue());
        }
        map.put("班级","17050411");
        map.put("人数","40");
        for(Map.Entry<String,String>entry:map.entrySet()){
            System.out.println(entry.getKey()+
                    "----->" +entry.getValue());
        }
        System.out.println(map.containsKey("班级"));
        System.out.println(map.containsValue("班级"));
        System.out.println(map.containsValue("顾富成"));
        System.out.println(map.get("班级"));
        System.out.println(map.getOrDefault("专业","会计"));
    }
}
