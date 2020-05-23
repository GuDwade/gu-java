package May;

public class Day14 {
    //只出现一次的数字 I II III

    //a^a=0;  a^0=a;
    public int singleNumber1(int[] nums) {
        int singleNumber=0;
        for(int num:nums){
            singleNumber^=num;
        }
        return singleNumber;
    }


    //除了一个数出现一次以外其余每个数都出现3次
    public int singleNumber2(int[] nums) {

        return  0;
    }
}
