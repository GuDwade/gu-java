import java.util.*;

public class First {
    //重复元素
    public int findRepeatNumber(int[] nums) {
        int ret=-1;
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> es:map.entrySet()){
            if(es.getValue()>1){
                ret=es.getKey();
                break;
            }
        }
        return ret;

    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return num;
            }else{
                set.add(num);
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    //二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (matrix[i][j]==target){
                    return  true;
                }
            }
        }

        return false;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int row=matrix.length;
        int col=matrix[0].length;
        //看作二叉搜索树
        int x=0,y=col-1;
        while(x<row&&y>=0){
            if(target>matrix[x][y]){
                y+=1;
            }else if(target<matrix[x][y]){
                x-=1;
            }else {
                return  true;
            }
        }

        return false;
    }
}
