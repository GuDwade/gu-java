import java.util.Arrays;

public class Day4 {
    public static int lengthOfLastWord(String s) {
        int end=s.length()-1;
        int count=0;
        for(int i=end;i>=0;i--){
            if(s.charAt(i)==' '){
                if(count==0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[]nums1Copy=Arrays.copyOfRange(nums1,0, m);
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1Copy[i]<=nums2[j]){
                nums1[k]=nums1Copy[i];
                k++;
                i++;
            }else{
                nums1[k]=nums2[j];
                k++;
                j++;
            }
        }
        if(i==m){
            System.arraycopy(nums2,j,nums1,k,n-j);
        }
        if(j==n){
            System.arraycopy(nums1Copy,i,nums1,k,m-i);
        }
    }
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while((i>=0)&&(j>=0)){
            if(nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }else{
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
        if(i<0){
            System.arraycopy(nums2,0,nums1,0,j+1);
        }

    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("gu fu cheng"));
        int[]nums1={1,2,3,0,0,0};
        int[]nums2={2,3,4};
        //merge1(nums1,3,nums2,3);
        //merge2(nums1,3,nums2,3);
        merge3(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
