public class Week_197 {

    public int numIdenticalPairs(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int count=0;
       for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i]){
                    count++;
                }
            }
       }
       return count;
    }

    public int numSub(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int count=0;
        int l=0,r=0;
        while (l<s.length()&&r<s.length()){
            while (l<s.length()&&s.charAt(l)!='1'){
                l++;
            }
            r=l;
            while (r<s.length()&&s.charAt(r)!='0'){
                r++;
            }
            count+=sub(r-l);
            l=r;
        }

        return  count;

    }

    private int sub(int n) {
        int ret=0;
        for(int i=n;i>0;i++){
            ret=(ret+i)%1000000007;
        }
        return  ret;
    }

}

