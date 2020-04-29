import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Day25 {
    private static Map<String,Integer>map=new HashMap<>();
    static int sum=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N=scanner.nextInt();
            scanner.nextLine();
            String name=scanner.nextLine();
            String[]candidate=name.split(" ");
            for(int i=0;i<N;i++){
                AddCandidate(candidate[i]);
            }
            map.put("Invalid",0);
            int peopleNum=scanner.nextInt();
            scanner.nextLine();
            String people=scanner.nextLine();
            String[]votePer=people.split(" ");
            for(int i=0;i<peopleNum;i++){
                Vote(votePer[i]);
            }
            for (int i=0;i<N;i++){
                System.out.println(candidate[i]+" : "+GetVoteResult(candidate[i]));
            }
            System.out.println("Invalid : "+map.get("Invalid"));
        }

    }
    private static int AddCandidate(String pCandidateName){
        if (!map.containsKey(pCandidateName)){
            map.put(pCandidateName,0);
            return 1;
        }else{
            return 0;
        }
    }

    private static void  Vote(String pCandidateName){

        if (map.containsKey(pCandidateName)){
            map.put(pCandidateName,map.get(pCandidateName)+1);
        }else{
            map.put("Invalid",map.get("Invalid")+1);
        }

    }

    private static int GetVoteResult(String pCandidateName){
        if (map.containsKey(pCandidateName)){
            return map.get(pCandidateName);
        }else{
            return -1;
        }
    }
    public static void Clear(){
        for (String candidate:map.keySet()){
            map.put(candidate,0);
        }
    }


    public static  void test(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int a=scanner.nextInt();
            System.out.println(sum(a)+" "+sum(a*a));
        }
    }
    private static int sum(int x) {
        int sum=0;
        while (x!=0){
            sum+=x%10;
            x=x/10;
        }
        return sum;
    }
}
