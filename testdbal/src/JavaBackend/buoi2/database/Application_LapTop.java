package JavaBackend.buoi2.database;


import JavaBackend.buoi2.database.models.LaptopEntity;
import JavaBackend.buoi2.database.services.LaptopServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application_LapTop {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!!");
        Connection connection =null;
        try{
            connection= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus?characterEncoding=utf8"
                            , "root", "159753");
            System.out.println("SQL Connection to database established!");
        }catch (SQLException e){
            System.out.println("Connection failed! Check output console "+e);
            return;
        }
        LaptopServices laptopServices=new LaptopServices(connection);
        laptopServices.Update_quantity_and_timestamp();

    }
}
