package JavaBackend.buoi7;

import JavaBackend.buoi2.database2.function.Work_by_Connection;
import JavaBackend.buoi7.Function.MYSQLConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainConnect {
    public static void main(String[] args) {
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
        MYSQLConnector main = new MYSQLConnector(connection);
        //main.EnumCar_ValidCondition_71_1();
        //main.InFor_Supplier_71_2();
        //main.InFor_Supllier_71_3();
        //main.Count_71_4();
        //main.EnuNameCar_71_5();
        //main.EnuInfor_71_6();
        //main.inFor_Supplier_71_7();
        main.inFor_Supplier_71_8();
    }
}
