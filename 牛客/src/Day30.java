import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Day30 {
    //错误记录
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer>map=new LinkedHashMap<>();
        while (scanner.hasNext()){
            String str=scanner.next();
            int row=scanner.nextInt();
            String record=buildRecord(str,row);
            int value=1;
            if(map.containsKey(record))
                map.put(record, map.get(record)+1);
            else {
                map.put(record, value);
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

    private static String buildRecord(String str, int row) {
        StringBuilder sb=new StringBuilder();
        String[] arr=str.split("\\\\");
        String name=arr[arr.length-1];
        if (name.length()>16){
            name=name.substring(name.length()-16);
        }
        sb.append(name);
        sb.append(' ');
        sb.append(row);
        return  sb.toString();
    }

    //翻转字符串
    public  static  void fun(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            System.out.println(reserve(str));
        }
    }
    private static String reserve(String str) {
        str.trim();
        int left=str.length()-1;
        int right=str.length()-1;
        StringBuilder  sb=new StringBuilder();
        while (left>=0){
            while (left>=0&&str.charAt(left)!=' '){
                left--;
            }
            String word=str.substring(left+1,right+1);
            sb.append(word);
            if (left>0){
                sb.append(' ');
            }
            right=left;
            while (right>=0&&str.charAt(right)==' '){
                right--;
            }
            left=right;
        }
        return sb.toString();
    }


}


