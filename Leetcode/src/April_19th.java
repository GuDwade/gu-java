import java.util.*;

public class April_19th {
	
    public String reformat(String s) {
        Queue<Character>nums=new LinkedList<>();
        Queue<Character>letters=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                nums.offer(s.charAt(i));
            }else{
                letters.offer(s.charAt(i));
            }
        }
        int abs=Math.abs(nums.size()-letters.size());
        if(abs>1){
            return new String("");
        }
        StringBuilder sb=new StringBuilder();
        int len1=nums.size(),len2=letters.size();
        for(int j=0;j<s.length();j++){
            if(len1>=len2){
                if(j%2==0){
                    sb.append(nums.poll());
                }else{
                    sb.append(letters.poll());
                }
            }else{
                if(j%2==0){
                    sb.append(letters.poll());
                }else{
                    sb.append(nums.poll());
                }
            }
        }

        return  sb.toString();
    }


}
