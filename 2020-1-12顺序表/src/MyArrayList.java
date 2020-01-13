import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList() {
        array = new int[10];
        size = 0;
    }

    //时间复杂度 空间复杂度都为O（1）
    public void pushBack(int element) {
        // array[size]=element;
        // size++;

        //array[size++] = element;

        insert(size,element);
    }

    public void popBack() {

        // array[size-1]=0;
        // size--;

        //array[--size] = 0;

        delete(size-1);
    }

    public void pushFront(int element) {
        // for(int i=size-1;i>=0,i--){
        // array[i+1]=array[i];
        // }
        // array[0]=element;
        // size++;

        /*System.arraycopy(array, 0, array, 1, size);
        // for(int i=size;i>0;i--){
        // array[i]=array[i-1];
        // }
        array[0] = element;
        size++;*/
        insert(0,element);
    }

    public void popFront() {
        /*System.arraycopy(array,1,array,0,size-1);
        //for (int i = 0; i < size; i++) {
            //array[i] = array[i + 1];
        //}
        array[--size] = 0;*/
        delete(0);
    }

    public void insert(int index, int element) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = 0;
    }

    public boolean contains(int find){
        for(int i=0;i<size;i++){
            if(array[i]==find){
                return true;
            }
        }
        return  false;
    }

    public int search(int find){
        for(int i=0;i<size;i++){
            if(array[i]==find){
                return i;
            }
        }
        return  -1;
    }

    public int getElement(int index){
        if(index>=size){
            return -1;
        }
        return array[index];
    }

    public void setElement(int index,int element){
        if(index>=size){
            return;
        }
        array[index]=element;
    }
    public void remove(int firstElement){
        for(int i=0;i<size;i++){
            if(array[i]==firstElement){
                delete(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public static void main(String[] args) {
        MyArrayList list=new MyArrayList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        System.out.println(list);
        list.pushBack(4);
        System.out.println(list);
        list.popFront();
        list.popBack();
        System.out.println(list);
        list.insert(2,8);
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
        System.out.println(list.contains(3));
        System.out.println(list.search(2));
        System.out.println(list.search(1));
        System.out.println(list.getElement(2));
        list.setElement(1,3);
        System.out.println(list);
        list.pushFront(3);
        list.remove(3);
        System.out.println(list);
    }
}