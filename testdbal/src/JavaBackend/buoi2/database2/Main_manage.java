package JavaBackend.buoi2.database2;

import JavaBackend.buoi2.database2.function.Work_by_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main_manage {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("MySQL JDBC not found !!");
            return;
        }
        Connection connection =null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/manage_student?characterEncoding=utf8"
                    , "root", "159753");
        }catch (SQLException e){
            System.out.println("Connection failed! Check output console "+e);
            return;
        }
        Work_by_Connection wbc = new Work_by_Connection(connection);
        wbc.Update_NUMBER_NoOfStudents();
    }
}
