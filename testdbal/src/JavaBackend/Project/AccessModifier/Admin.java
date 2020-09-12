package JavaBackend.Project.AccessModifier;

import JavaBackend.Project.ConnectDB.DataBase;


import java.sql.Connection;

public class Admin extends DataBase {
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
