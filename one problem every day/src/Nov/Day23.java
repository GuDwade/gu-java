package Nov;

import java.util.Stack;

public class Day23 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return  false;
        }
        int[] cnt = new int[26];
        for(char ch : s.toCharArray()){
            cnt[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            if (cnt[ch - 'a'] == 0){
                return  false;
            }
            cnt[ch - 'a']--;
        }
        return  true;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return  0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int area = 0;

        for(int i = 0; i < m; i++) {
           for(int j = 0; j < n; j++) {
               if (matrix[i][j] == '1'){
                   heights[j]++;
               }else{
                   heights[j] = 0;
               }
           }

           area = Math.max(area,largestRectangle(heights));
        }

        return  area;
    }

    private int largestRectangle(int[] heights) {
        int[] arr = new int[heights.length+2];
        System.arraycopy(heights,0,arr,1,heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;

        for(int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i] ) {
                int h = arr[stack.pop()];
                while (!stack.isEmpty() && arr[stack.peek()] == h){
                    stack.pop();
                }
                area = Math.max(area,h*(i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return  area;
    }

    public static void main(String[] args) {

    }
}
