package JavaBackend.Project.AccessModifier;

import java.sql.Connection;

public class Admin {
    private Connection con;
    public Admin(){

    }
    public Admin(Connection con){
        this.con=con;
        ProgramAdmin();
    }
    private void ProgramAdmin(){

    }
}
