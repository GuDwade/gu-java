public class Get {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取Class类的实例的方法

        //1.调用运行时类的属性 .class

        Class clazz1=Person.class;
        System.out.println(clazz1);

        //2.调用运行时类的对象，调用getClass()
        Person p1=new Person("gu",20);
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //3.调用Class的静态方法，forName(String class)
        Class class3=Class.forName("Person");
        System.out.println(class3);


        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==class3);
        
        //类加载器

        ClassLoader classLoader = Get.class.getClassLoader();
        Class clazz4=classLoader.loadClass("Person");
        System.out.println(clazz4);
        System.out.println(Math.round(-2.6));
        System.out.println(Math.round(12.5));
    }
}
