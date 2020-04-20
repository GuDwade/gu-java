import java.util.*;

public class Day18 {

    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[]ret=new boolean[n];
        for(int i=0;i<n;i++){
            ret[i]=isSubString(p[i],s);
        }
        return  ret;
    }
    public static boolean isSubString(String p,String s){
        if(p.length()>s.length()){
            return  false;
        }

        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<p.length();i++){
            Integer count =map.get(p.charAt(i));
            if(count==null||count==0){
                return  false;
            }else{
                map.put(p.charAt(i),count-1);
            }
        }
        return  true;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int number=scanner.nextInt();
            int sort=scanner.nextInt();
            PriorityQueue<Student> pq=new PriorityQueue<>();
            if(sort==0){
                pq=new PriorityQueue<>(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int ret= o2.grade-o1.grade;
                        if(ret<0){
                            return -1;
                        }else if(ret>0){
                            return  1;
                        }else{
                            return 0;
                        }
                    }
                });
            }
            if(sort==1){
                pq=new PriorityQueue<>(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int ret= o1.grade-o2.grade;
                        if(ret<0){
                            return -1;
                        }else if(ret>0){
                            return  1;
                        }else{
                            return 0;
                        }
                    }
                });
            }
            for(int i=0;i<number;i++){
                if (pq.size()<number){
                    String name=scanner.next();
                    int grade=scanner.nextInt();
                    pq.offer(new Student(name,grade));
                }
            }

            while (!pq.isEmpty()){
                System.out.println(pq.poll());
            }
        }

    }
}
class  Student {
    String name;
    int  grade;

    Student(String name,int grade){
        this.name=name;
        this.grade=grade;
    }

    @Override
    public String toString(){
        return  name+" "+grade;
    }
}
