package Nov;

public class Day3 {
    //有效的山脉数组

    public boolean validMountainArray(int[] A) {
        if(A ==null || A.length<3){
            return  false;
        }

        int i=0, j=A.length-1;
        while (i<j&&A[i]<A[i+1]){
            i++;
        }

        while (i<j&&A[j]<A[j+1]){
            j--;
        }

        return (i!=0 && j!=A.length-1) &&i==j;
    }

}
