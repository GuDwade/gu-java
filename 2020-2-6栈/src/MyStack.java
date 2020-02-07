import java.util.Arrays;

public class MyStack {
    private int[]array;
    private int size;
    MyStack(int n){
        array=new int[n];
        size=0;
    }
    //入栈
    public void push(int value){
        if(size == array.length){
            array = Arrays.copyOf(array, 2 * size);
        }
        array[size++] = value;
    }
    //出栈
    public void pop(){
        if(size > 0){
            array[size--]=0;
        }
    }
    //栈顶元素
    public int peek(){

        return array[size - 1];
    }

    public int size(){

        return size;
    }

    public boolean empty(){

        return size == 0;
    }

    public void bianli(){
        while(size>0){
            System.out.print(peek() + " ");
            pop();
        }
    }
    public static void main(String[] args) {
        MyStack st = new MyStack(2);
        System.out.println(st.size());
        System.out.println(st.empty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.size());
        System.out.println(st.empty());
        st.pop();
        System.out.println(st.size());
        st.bianli();

    }
}
