import java.util.Arrays;
import java.util.HashSet;

public class Day1 {
    //分糖果
    public static int[] distributeCandies(int candies, int num_people) {
        int[]ans=new int[num_people];
        int sum=candies;
        int i=0;
        int give=1;
        while(sum>0){
            ans[i++]+=give;
            //防止越界
            i=i%ans.length;
            sum-=give;
            if(sum>give){
                give++;
                continue;
            }else{
                ans[i]+=sum;
                break;
            }
        }
        return ans;
    }

    public static int distributeCandies(int[] candies) {
        //分到最多的可能性
        int max=candies.length/2;
        HashSet<Integer>set=new HashSet<>();
        //得到糖果的种类
        for(int val:candies){
            set.add(val);
        }
        //如果糖果种类比max大 妹妹必定分到max种
        //如果比max小 妹妹优先分到所有种不同的糖 再补全
        //所以返回小者
        return  Math.min(max,set.size());
    }

    public static void main(String[] args) {
        int[] candies={1,2,3,4,5,6,3,4,5,6};
        System.out.println(distributeCandies(candies));
        int[] candies1={1,1,1,2,2,2};
        System.out.println(distributeCandies(candies1));
        System.out.println(Arrays.toString(distributeCandies(55,5)));
    }
}
