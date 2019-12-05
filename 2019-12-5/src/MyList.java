import java.util.List;
import java.util.ArrayList;

public class MyList {
        public static int balancedStringSplit(String s) {
            int count =0;
            List<Character> list=new ArrayList<>();
            for(char c:s.toCharArray()){
                if(list.isEmpty()){
                    list.add(c);
                }else if(c==list.get(list.size()-1)){
                    list.add(c);
                }else{
                    list.remove(list.size()-1);
                    if(list.isEmpty()){
                        count++;
                    }
                }

            }
            return count;
        }

    public static void main(String[] args) {
        String str="RRLLlRlR";
        int r=balancedStringSplit(str);
        System.out.println(r);
    }
}
