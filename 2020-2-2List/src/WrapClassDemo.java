public class WrapClassDemo {
    public static void main(String[] args) {

        int i=10;
        Integer iobj=Integer.valueOf(i);//手动装箱
        int a= iobj.intValue();//手动拆箱

        Integer iobj1=20;//自动装箱
        int a1=iobj1;//自动拆箱

        Integer iobj2=(Integer) 30;//自动装箱
        int a2=(int)iobj2;//自动拆箱


    }

}
