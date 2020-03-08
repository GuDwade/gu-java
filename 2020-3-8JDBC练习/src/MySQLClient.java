import java.sql.*;
import java.util.Scanner;

public class MySQLClient {
    /*
    private static String ip;
    private static int port;
    private static String user;
    private static String password;
    private static String defaultDatabase;

    private static void parseArgs(String[] args) {
        ip = args[0].substring(2);
        port = Integer.parseInt(args[1].substring(2));
        user = args[2].substring(2);
        defaultDatabase = args[4];
        System.out.print("Enter password: ");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println(ip);
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
        System.out.println(defaultDatabase);
    }
    */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 模仿从参数中获取MySQL Server的信息
        //parseArgs(args);
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        // 先指定 MySQL 服务器的位置
        String ur1="jdbc:mysql://127.0.0.1:3306/java14_0308?uscSSL=false&characterEncoding=utf8";
        Connection connection=DriverManager.getConnection(ur1,"root","");
        //System.out.println(connection);

        // 从 Scanner 中不停的读 SQL，并执行
       Scanner scanner = new Scanner(System.in);
       while(true){
           System.out.print("mysql> ");
           String sql=scanner.nextLine();
           if (sql.trim().isEmpty()) {
               continue;
           }
           if(sql.equalsIgnoreCase("quit")){
               break;
           }
           Statement statement=connection.createStatement();

           String firstWord = sql.split(" ")[0];
           if (firstWord.equalsIgnoreCase("select")
                   || firstWord.equalsIgnoreCase("show")
                   || firstWord.equalsIgnoreCase("desc")) {
               // 有结果的 SQL
               executeSQLWithResult(statement, sql);
           } else {
               // 没有结果的 SQL
               executeSQLWithoutResult(statement, sql);
           }

           statement.close();
       }

        //4. 关闭连接
        connection.close();
    }

    private static void executeSQLWithoutResult(Statement statement, String sql) throws SQLException {
        int affect=statement.executeUpdate(sql);
        //create drop update insert  delete
        System.out.println("受到影响的行数"+affect);
    }

    private static void executeSQLWithResult(Statement statement, String sql) throws SQLException {
        ResultSet rs= statement.executeQuery(sql);
        //select show desc
        // 取到结果集元信息
        ResultSetMetaData metaData=rs.getMetaData();
        int columnCount=metaData.getColumnCount();

        for(int i=1;i<=columnCount;i++){
            String columnName=metaData.getColumnName(i);
            System.out.print(columnName+" ");
        }
        System.out.println();
        while(rs.next()){
            for(int i=1;i<=columnCount;i++){
                String values=rs.getString(i);
                System.out.print(values+" ");
            }
            System.out.println();
        }
        rs.close();
    }
}
