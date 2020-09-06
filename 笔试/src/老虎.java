import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 老虎 {
//       public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String a=scan.nextLine();
//            String b=scan.nextLine();
//            System.out.println(removeLetters(a,b));
//        }
//    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            Score[]scores=new Score[n];
            for(int i=0;i<n;i++){
                scores[i]=new Score(scan.nextInt(),scan.nextInt());
            }
            Arrays.sort(scores,(s1,s2)->{
                int ret=s1.score-s2.score;
                if (ret==0){
                    ret=s1.id-s2.id;
                }
                return  ret;
            });
            for(int i=0;i<n;i++){
                System.out.println(scores[i]);
            }
        }
    }
    private static String removeLetters(String a, String b) {
        StringBuilder sb=new StringBuilder();
        Set<Character> set=new HashSet<>();
        for(char ch:b.toCharArray()){
            set.add(ch);
        }
        for(int i=0;i<a.length();i++){
            char cur=a.charAt(i);
            if (!set.contains(cur)){
                sb.append(cur);
            }
        }
        return  sb.toString();
    }
}

class Score{
    int id;
    int score;

    public Score(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public Score() {
    }

    @Override
    public String toString() {
        return  id+" "+score;
    }
}