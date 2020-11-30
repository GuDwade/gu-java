package Nov;

import java.util.Arrays;

public class Day25 {
    int cnt;
    public int countNodes(TreeNode root) {
        cnt = 0;
        preOrder(root);
        return  cnt;
    }

    private void preOrder(TreeNode root) {
        if (root != null){
            cnt++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //插入区间
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ret = new int[intervals.length+1][2];
        int i = 0 , idx = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            ret[idx++] = intervals[i++];
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ret[idx++] = newInterval;
        while (i < intervals.length){
            ret[idx++] = intervals[i++];
        }
        return Arrays.copyOf(ret,idx);
    }

    public int removeCoveredIntervals(int[][] intervals) {
        int cnt = intervals.length;
        Arrays.sort(intervals,(o1,o2) -> {
            return  o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        });
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
           if (intervals[i][1] <= right){
               cnt--;
           }else{
                right = intervals[i][1];
           }
        }

        return  cnt;
    }

    public static String sortString(String s) {
        int[] nums = new int[26];
        for(char ch :s.toCharArray()){
            nums[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = s.length();
        while (cnt > 0) {
            for(int i = 0; i< 26 ;i++){
                if (nums[i] > 0){
                    sb.append((char)(i+'a'));
                    nums[i]--;
                    cnt--;
                }
            }

            for(int i = 25; i >= 0; i--){
                if (nums[i] > 0){
                    sb.append((char)(i+'a'));
                    nums[i]--;
                    cnt--;
                }
            }
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(insert(new int[][]{
                {2, 5}, {6, 7}, {8, 9}, {0, 1}
        }, new int[]{0, 1}));
        System.out.println(sortString("aaaabbbbcccc"));
    }


}
