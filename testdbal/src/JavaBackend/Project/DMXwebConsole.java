package JavaBackend.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DMXwebConsole {
    public static void main(String[] args) {
        System.out.println("Đang tải web....");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("MySQL JDBC not found");
            return;
        }
        Connection connection = null;
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/thue_xe_cms?characterEncoding=utf8"
                    , "root", "159753");

        }catch (SQLException e){
            System.out.println("Connection failed! Check output console "+e);
            return;
        }
        ExecuteWeb web = new ExecuteWeb(connection);

    }
}
