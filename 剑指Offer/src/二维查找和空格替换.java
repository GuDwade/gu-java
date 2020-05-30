public class 二维查找和空格替换 {

    public boolean searchArray(int[][] array, int target) {
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        int i=0,j=array[0].length-1;
        while (i<=array.length&&j>=0){
            if (array[i][j]>target){
                j-=1;
            }else if(array[i][j]<target){
                i+=1;
            }else{
                return  true;
            }
        }
        return  false;
    }

    public String replaceSpaces(StringBuffer str) {
        String s=str.toString();
        StringBuilder sb=new StringBuilder();
        for(char tmp:s.toCharArray()){
            if (tmp==' '){
                sb.append("%20");
            }else{
                sb.append(tmp);
            }
        }

        return  sb.toString();
    }
}
