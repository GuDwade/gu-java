package December;

public class Day18 {
	//找不同
	
    public char findTheDifference(String s, String t) {
        int sum1=0;
        for(char ch:s.toCharArray()){
            sum1+=ch;
        }

        int sum2=0;
        for(char ch:t.toCharArray()){
            sum2+=ch;
        }
        
        return (char)(sum2-sum1);
    }
}
