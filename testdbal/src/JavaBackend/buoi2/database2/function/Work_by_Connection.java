package JavaBackend.buoi2.database2.function;

import JavaBackend.buoi2.database2.Target.AddAverage;
import JavaBackend.buoi2.database2.Target.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void CPA(){
        List<AddAverage> aDD= new ArrayList<>();
        String sql="SELECT  results.StudentID,results.CourseID,results.Mark,courses.Credits FROM results,courses,students" +
                "WHERE results.CourseID = courses.CourseID";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                AddAverage addAverage= new AddAverage(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
                for(AddAverage ad :aDD){
                    if(ad.getStudentID().equals(addAverage.getStudentID()) && ad.getCourseID().equals(addAverage.getCourseID())){
                        if(ad.getMark()<addAverage.getMark()){
                            aDD.add(addAverage);
                        }
                    }else {
                        aDD.add(addAverage);
                    }
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        HashMap<String,Double> diemthi=new HashMap<>();
        double diem=aDD.get(0).getMark()*aDD.get(0).getCredits();
        diemthi.put(aDD.get(0).getStudentID(),diem);
        for(int i=1;i<aDD.size();i++){
            if(!aDD.get(i).getStudentID().equals(aDD.get(i-1).getStudentID())){
                diem=0;
            }
            diem+=aDD.get(i).getMark()*aDD.get(i).getCredits();
            diemthi.put(aDD.get(i).getStudentID(),diem);
        }
        try{
            Statement stmt = con.createStatement();
            for (int i=0;i<diemthi.size();i++){
                String sql_update="UPDATE students SET AverageScore = "+diemthi.values()+" WHERE StudentID='"+diemthi.keySet()+"'";
                int k=stmt.executeUpdate(sql_update);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }





        }

    }
