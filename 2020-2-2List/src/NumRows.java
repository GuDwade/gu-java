import java.util.ArrayList;
import java.util.List;

public class NumRows {
    public static List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }
        List<List<Integer>>list= new ArrayList<>();
        int[][]array=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            List<Integer>subList=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    array[i][j]=1;
                }else{
                    array[i][j]=array[i-1][j-1]+array[i-1][j];
                }
                subList.add(array[i][j]);
            }
            list.add(subList);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(0));
    }
}
