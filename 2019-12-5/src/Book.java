import java.util.Scanner;

public class Book  implements  Comparable<Book>{
    public String ISBN;
    public String title;
    public String author;
    public int price;
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Book)){
            return  false;
        }
        Book book=(Book)obj;
        return this.ISBN.equals(book.ISBN);
    }
    public int compareTo(Book book){
        return this.price-book.price;
    }
    public static void main(String[] args) {
        Book book1=new Book();
        book1.ISBN="111";
        book1.title="牢底坐穿";
        book1.author="法律";
        book1.price=1100;
        Book book2=new Book();
        book2.ISBN="111";
        book2.title="牢底坐穿";
        book2.author="法律";
        book2.price=11023    ;
        System.out.println(book1.equals(book2));
        System.out.println(book1.compareTo(book2));
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        if(line.equalsIgnoreCase("价格")){
            int r=book1.compareTo(book2);
            System.out.println(r);
        }else if(line.equalsIgnoreCase("ISBN")) {
            boolean r = book1.equals(book2);
            System.out.println(r);
        }

    }
}
