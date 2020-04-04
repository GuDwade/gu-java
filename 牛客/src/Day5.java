import java.util.*;
public class Day5 {
    //摩尔投票 一换一
    public int majorityElement2(int[] nums) {
        int val=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if (nums[i]==val){
                count++;
            }else{
                count--;
                if (count==0){
                    val=nums[i+1];
                }
            }
        }
        return val;
    }

    public static void main(String[] args) {

        /*
        Scanner scan=new Scanner(System.in);
        int a_b=scan.nextInt();
        int b_c=scan.nextInt();
        int aAddB=scan.nextInt();
        int bAddC=scan.nextInt();

        int A=(a_b+aAddB)/2;
        int B=(b_c+bAddC)/2;
        int C=bAddC-B;

        if(a_b==A-B&&b_c==B-C&&aAddB==A+B&&bAddC==B+C){
            System.out.println();
        }else{
            System.out.println("No");
        }
        */

        //多数
        Scanner scan=new Scanner(System.in);
        List<Integer>list=new LinkedList<>();
        Set<Integer>set=new HashSet<>();

        while(scan.hasNextInt()){
           list.add(scan.nextInt());
        }

        for(int i=0;i<list.size();i++){
            int value=list.get(i);
            if(set.contains(value)){
                continue;
            }
            set.add(value);
            int count=1;
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)==value){
                    count++;
                }
            }

            if(count>=list.size()/2){
                System.out.println(value);
                break;
            }
        }
    }
}
