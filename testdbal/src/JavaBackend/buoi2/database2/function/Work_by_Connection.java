package JavaBackend.buoi2.database2.function;

import JavaBackend.buoi2.database2.Target.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Work_by_Connection {
    private Connection con;
    private Scanner sc= new Scanner(System.in);
    public Work_by_Connection(){

    }
    public Work_by_Connection(Connection connection){
        this.con=connection;
    }

    ////Activity 53.1 Cập nhật số lượng sinh viên cho bảng Department
    public void Update_NUMBER_NoOfStudents(){
        short q=0;
        do {
            System.out.print("Which 'DeptID' do you choose to update?(CE/IS/NC/SE): ");
            String DeptID = sc.nextLine();
            System.out.print("Set amount changing:");
            String NoOfStudents = sc.nextLine();
            String sql = "UPDATE departments SET NoOfStudents='" + NoOfStudents + "' WHERE DeptID='" + DeptID + "'";
            try {
                Statement stmt = con.createStatement();
                int k = stmt.executeUpdate(sql);
                ResultSet rs = stmt.executeQuery("SELECT * FROM departments WHERE DeptID='" + DeptID + "'");
                while (rs.next()) {
                    Department dpmt = new Department(rs.getString(1), rs.getString(2), rs.getString(3));
                    System.out.println(dpmt.toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("Finish??(1=YES,2=NO)");
            q = sc.nextShort();
            sc.nextLine();
        }while(q!=1);
    }

    //// Activity 53.2 Tính điểm trung bình
    public float CPA(){
        float CPA=0;
        
        return CPA ;
    }
}
