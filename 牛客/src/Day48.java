import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day48 {
    //马戏团
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            Person []arr=new Person[n];
            for(int i=0;i<n;i++){
                int idx=scan.nextInt();
                arr[idx-1]=new Person(scan.nextInt(),scan.nextInt());
            }
            Arrays.sort(arr, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                   int result=Integer.compare(o1.height,o2.height);
                   if(result!=0){
                       return  result;
                   }else{
                       return Integer.compare(o1.weight,o2.weight);
                   }
                }
            });

            int[]dp=new int[n];
            int max=-1;
            for(int i=0;i<n;i++){
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if (arr[i].weight>arr[j].weight||(arr[i].weight==arr[j].weight&&arr[i].height==arr[j].height)){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max=Math.max(max,dp[i]);
            }
            System.out.println(max);
        }
    }

}
class Person{
    int height;
    int weight;

    Person(int height,int weight){
        this.height=height;
        this.weight=weight;
    }
}
