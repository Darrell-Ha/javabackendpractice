package JavaBackend.Project;

import JavaBackend.Project.AccessModifier.Admin;
import JavaBackend.Project.AccessModifier.User;

import java.sql.Connection;
import java.util.Scanner;

public class ExecuteWeb {
    private Connection con;
    private Scanner sc= new Scanner(System.in);
    public ExecuteWeb(Connection con){
        this.con=con;
        System.out.println("Bạn là admin/user?? : ");
        if(sc.nextLine().equals("admin")){
            Admin ad= new Admin(con);
        }else{
            User us= new User(con);
        }
    }
}
