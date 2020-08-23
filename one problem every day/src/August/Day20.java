package August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day20 {
    //圆形赛道上经过次数最多的扇区
    public static List<Integer> mostVisited(int n, int[] rounds) {
        int[]count=new int[n+1];

        for(int i=0;i<rounds.length-1;i++){
            int start=rounds[i],end=rounds[i+1];
            while (start!=end){
                count[start]++;
                start=(start+1)%(n+1);
                start=start==0?1:start;
            }
        }
        count[rounds[rounds.length-1]]++;
        int max=0;
        for(int cnt:count){
            max=Math.max(max,cnt);
        }
        List<Integer>ret=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if (count[i]==max){
                ret.add(i);
            }
        }
        return ret;
    }

    //你可以获得的最大硬币数目
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int Bob=0;
        int Alice=piles.length-1;
        int max=0;
        while (Bob+1<Alice){
            int me=Alice-1;
            max+=piles[me];
            Bob++;
            Alice-=2;
        }
        return max;
    }

    //查找大小为 M 的最新分组
    public static int findLatestStep(int[] arr, int m) {
        int sz=arr.length;
        if (m>sz){
            return -1;
        }
        if (m==sz){
            return sz;
        }
        boolean[]isHas=new boolean [sz+1];

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<sz;i++){
            sb.append(0);
        }

        for(int i=1;i<=sz;i++){
            sb.setCharAt(arr[i-1]-1,'1');
            isHas[i]=judge(sb,m);
        }

        for(int i=sz;i>=0;i--){
            if (isHas[i]){
                return i;
            }
        }

        return -1;
    }

    private static boolean judge(StringBuilder sb,int m) {
        int len=sb.length();
        int idx=0;

        while (idx<len){
            while (idx<len&&sb.charAt(idx)=='0'){
                idx++;
            }
            int start=idx;
            while (idx<len&&sb.charAt(idx)=='1'){
                idx++;
            }
            if(idx-start==m){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
      //  System.out.println(mostVisited(4, new int[]{1,3, 1,2}));
        // System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
        System.out.println(findLatestStep(new int[]{1},1));
    }
}
