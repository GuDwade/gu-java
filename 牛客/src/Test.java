import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            System.out.println(longestSub(str));
        }

        Test test=new Test();
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4, 5, 3, 6, 1, 2, 8, 7}, 4));
        */
        Scanner scanner=new Scanner(System.in);
        List<Desk>desks=new ArrayList<>();
        List<Custom>customs=new ArrayList<>();
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            for(int i=0;i<n;i++){
                desks.add(new Desk(scanner.nextInt()));
            }
            for (int j=0;j<m;j++){
                customs.add(new Custom(scanner.nextInt(),scanner.nextInt()));
            }
            Collections.sort(desks, new Comparator<Desk>() {
                @Override
                public int compare(Desk o1, Desk o2) {
                    return o1.person-o2.person;
                }
            });

            Collections.sort(customs, new Comparator<Custom>() {
                @Override
                public int compare(Custom o1, Custom o2) {
                    int ret=o1.perNum-o2.perNum;
                    if(ret==0){
                        ret=o1.total-o2.total;
                    }
                    return  ret;
                }
            });

            int sum=0;

            for(int i=0;i<n;i++){
                Desk desk=desks.get(i);
                int max=-1,idx=-1;
                int end=0;
                while (end<customs.size()&&customs.get(end).perNum<=desk.person){
                    end++;
                }
                for(int j=0;j<end;j++){
                    if (customs.get(j).total>max){
                        max=customs.get(j).total;
                        idx=j;
                    }
                }
                sum+=max;
                customs.remove(idx);
            }
            System.out.println(sum);
        }


    }

    private static String longestSub(String str) {
        int start=0,len=0;
        int left=0,right=0;

        while (left<str.length()){
            while (left<str.length()&&!isNum(str.charAt(left))){
                left++;
            }

            right=left;

            while (right<str.length()&&isNum(str.charAt(right))){
                right++;
            }

            if (right-left>len){
                start=left;
                len=right-left;
            }
            left=right;
        }

        return str.substring(start,start+len);

    }

    private static boolean isNum(char c) {
        return  c<='9'&&c>='0';
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>ret=new ArrayList<>();
        if (input.length==0||input==null||k<=0||k>input.length){
            return ret;
        }
        for(int i=input.length-2/2;i>=0;i--){
            shiftDown(input,input.length,i);
        }
        for(int i=0;i<k;i++){
            swap(input,0,input.length-1-i);
            shiftDown(input,input.length-1-i,0);
        }

        for(int i=0;i<k;i++){
            ret.add(input[input.length-1-i]);
        }
        return  ret;
    }

    public void shiftDown(int[] array, int size, int index) {
        int left=2*index+1;
        while(left<size){
            int min=left;
            int right=2*index+2;
            if(right<size&&array[right]<array[left]){
                min=right;
            }
            if (array[index]<=array[min]){
                break;
            }
            if(array[index]>array[min]){
                swap(array,index,min);
            }
            index=min;
            left=2*index+1;
        }
    }

    public  void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
class Custom{
    int perNum;
    int total;

    public Custom(int perNum,int total){
        this.perNum=perNum;
        this.total=total;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "perNum=" + perNum +
                ", total=" + total +
                '}';
    }
}

class Desk{
    int person;

    public  Desk(int person){
        this.person=person;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "person=" + person +
                '}';
    }
}