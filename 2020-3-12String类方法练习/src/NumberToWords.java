public class NumberToWords {
    //整数转换英文表示
	
    String[]small={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine", "Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[]decade={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[]big={"Billion","Million","Thousand",""};

    public String numberToWords(int num) {
        if (num==0){
            return  small[0];
        }

        StringBuilder res=new StringBuilder();
        for(int i=1000000000,j=0;i>0;i/=1000,j++){
            if (num>=i){
                res.append(getPart(num/i)+big[j]+' ');
                num%=i;
            }
        }
        return res.toString().trim();
    }

    private String  getPart(int num){
        StringBuilder sb=new StringBuilder();
        if (num>=100){
            sb.append(small[num/100]);
            sb.append(" Hundred ");
            num%=100;
        }

        if (num==0){
            return sb.toString();
        }

        if (num>=20){
            sb.append(decade[num/10]+' ');
            num%=10;
        }

        if (num==0){
            return sb.toString();
        }

        sb.append(small[num]+' ');
        return sb.toString();
    }
}
