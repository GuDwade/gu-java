public class StringLearning {
    public static void main(String[] args) {
        //构造方式
        String str="gufucheng";
        String str7="gufucheng";
        System.out.println("gufucheng".equals(str));
        System.out.println(str.equals(str7));//常量池中，指向同一对象
        String str1=new String("gufucheng");
        String str0=new String("gufucheng");//
        System.out.println(str1==str0);
        String str12=new String(str);
        char[]name={'g','u','f','u','c','h','e','n','g'};
        String str2=new String(name);
        System.out.println(str.length());
        System.out.println(str1.length());
        System.out.println(str==str1);//引用
        System.out.println(str.equals(str1));//内容;
        System.out.println(str.equals(str12));
        System.out.println(str2.length());
        System.out.println(str.equals(str2));
        //
    }
}
