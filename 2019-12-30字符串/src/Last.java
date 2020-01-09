import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Last {
    public static String[] splitString(String s1,String s2){
        List<String> list=new ArrayList<String>();
        while(s1.contains(s2)){
            int index=s1.indexOf(s2);
            String tmp=s1.substring(0,index);
            list.add(tmp);
            s1=s1.substring(index+s2.length());
        }
        list.add(s1);
        String[] arr=new String[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static String replace(String s, String t, String r) {
        StringBuilder sb=new StringBuilder();
        int time = 0;
        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s1.length && j < t1.length) {
            if (s1[i] == t1[j]) {
                i++;
                j++;
                if (j == t1.length) {
                    time++;
                    sb = sb.append(r);
                    j = 0;
                }
            } else {
                    i = i - j + 1;
                    j = 0;
                    sb = sb.append(String.valueOf(s1[i - 1]));
              }
        }
        String str=sb.toString();
        if(time==0){
            return  s;
        }else {
            return str;
        }
    }

    public static void main(String[] args) {
       String[]arr=splitString("welcome to china"," ");
       System.out.println(Arrays.toString(arr));
       String str=replace("hello","ello","ehe");
       System.out.println(str);

    }

}
