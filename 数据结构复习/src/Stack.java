import java.util.Arrays;

public class Stack {

    private  int[] array;
    private  int size;

    public  Stack(int n){
        array = new int[n];
        size  = 0;
    }

    //插入
    public void push(int val) {
        // 扩容
        if(size == array.length){
            array = Arrays.copyOf(array,array.length * 2);
        }
        // 尾插
        array[size++] = val;
    }


    public void pop(){
        if(size > 0){
            size--;
        }
    }

    public int peek(){
        return array[size - 1];
    }

    public int size(){
        return size;
    }


    public boolean empty(){
        return size == 0;
    }


}
