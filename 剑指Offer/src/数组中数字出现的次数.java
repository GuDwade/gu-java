public class 数组中数字出现的次数 {

    //两个只出现一次的数字
    public int[] singleNumbers(int[] nums) {
        int[]ret={0,0};
        int num=0;
        for(int i:nums){
            num^=i;
        }
        int flag=num&(-num);
        for(int i:nums){
            if ((i&flag)==0){
                ret[0]^=i;
            }else{
                ret[1]^=i;
            }
        }
        return ret;
    }

    //一个数字只出现一次之外，其他数字都出现了三次
    public int singleNumber(int[] nums) {
       int []bits=new int[32];//int 32位
        //计算每个数 每一位 的个数总和
        for(int num:nums){
            int bitFlag=1;//每一位去判断
            for(int i=31;i>=0;i--){
                if((num&bitFlag)!=0){
                    bits[i]++;
                }
                bitFlag<<=1;
                //0000 0001
                //0000 0010
            }
        }
       //每一位%3 左移
        int ret=0;
        for(int i=0;i<32;i++){
            ret<<=1;
            ret+=bits[i]%3;
        }
        return ret;
    }
}
