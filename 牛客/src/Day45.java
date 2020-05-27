import java.util.*;

public class Day45 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            String[] arr = new String[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.next();
            }
            String key = scan.next();
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int num = scan.nextInt();
            int count = 0;
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0;i<n;i++){
                 if(isBrother(key,arr[i],keyChar)){
                     count++;
                     list.add(arr[i]);
                 }
            }
            System.out.println(count);
            Collections.sort(list);
            if(count>=num){
                System.out.println(list.get(num-1));
            }

        }
    }

    //兄弟单词
    private static boolean isBrother(String key, String word, char[] keyChar) {
        if(key.equals(word)||key.length()!=word.length()){
            return  false;
        }
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar, wordChar);

    }




    //乒乓球筐
    private static void judeg(String a, String b) {
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:a.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:b.toCharArray()){
            Integer cnt=map.get(ch);
            if (cnt==null||cnt==0){
                System.out.println("No");
                return;
            }
            map.put(ch,cnt-1);
        }
        System.out.println("Yes");
    }


}
