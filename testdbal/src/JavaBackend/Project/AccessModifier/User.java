package JavaBackend.Project.AccessModifier;

import java.sql.Connection;

public class User {
    private Connection con;
    public User(){

    }
    public User(Connection con){
        this.con=con;
        ProgramUser();
    }
    private void ProgramUser(){

    }
}
