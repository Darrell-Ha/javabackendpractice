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
        String sql="SELECT  results.StudentID,results.CourseID,results.Mark,courses.Credits FROM results,courses " +
                "WHERE results.CourseID = courses.CourseID";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                AddAverage addAverage= new AddAverage(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
                aDD.add(addAverage);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        List<AddAverage> process = new ArrayList<>();
        for (int i=0;i<aDD.size()-1;i++){
            int index=i;
            for (int k=i+1;k<aDD.size();k++){
                if(aDD.get(index).getStudentID().equals(aDD.get(k).getStudentID()) && aDD.get(index).getCourseID().equals(aDD.get(k).getCourseID())){
                    if(aDD.get(index).getMark()<aDD.get(k).getMark()){
                        index=k;
                    }
                }
            }
            if (!process.contains(aDD.get(index))){
                process.add(aDD.get(index));
            }
        }
        if(!process.contains(aDD.get(aDD.size()-1).getStudentID()) && !process.contains(aDD.get(aDD.size()-1).getCourseID())){
            process.add(aDD.get(aDD.size()-1));
        }
        for (AddAverage ad: process){
            System.out.println(ad.toString());
        }
        HashMap<String,Double> diemthi=new HashMap<>();
        double diem=process.get(0).getMark()*process.get(0).getCredits();
        diemthi.put(process.get(0).getStudentID(),diem);
        int credits =process.get(0).getCredits();
        for(int i=1;i<process.size();i++){
            if(!process.get(i).getStudentID().equals(process.get(i-1).getStudentID())){
                diemthi.put(process.get(i-1).getStudentID(),diem/credits);
                diem=0;
                credits=0;
            }
            diem+=process.get(i).getMark()*process.get(i).getCredits();
            credits+=process.get(i).getCredits();
            diemthi.put(process.get(i).getStudentID(),diem);
        }
        diemthi.put(process.get(process.size()-1).getStudentID(),diem/credits);
        try{
            Statement stmt = con.createStatement();
            for (String key:diemthi.keySet()){
                String sql_update="UPDATE students SET AverageScore = "+diemthi.get(key)+" WHERE StudentID='"+key+"'";
                stmt.executeUpdate(sql_update);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        }

    }
