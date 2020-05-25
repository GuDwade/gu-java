import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day43 {
    //求和
    static List<List<Integer>>ret;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        ret=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        int []nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        dfs(nums,m,list,0);
        for(int i=0;i<ret.size();i++){
            for(int j=0;j<ret.get(i).size();j++){
                System.out.print(ret.get(i).get(j));
                if(j<ret.get(i).size()-1){
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int[] nums, int m, List<Integer> list,int idx) {
        if (m==0){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(m-nums[idx]<0){
                break;
            }
            m-=nums[i];
            list.add(nums[i]);
            dfs(nums, m, list, i+1);
            m+=nums[i];
            list.remove(list.size()-1);
        }
    }

}
