package JavaBackend.Project.AccessModifier;

import JavaBackend.Project.ConnectDB.DataBase;
import JavaBackend.Project.Product.Product;

import java.sql.Connection;
import java.util.List;

public class User extends DataBase {
    private Connection con;
    public User(){

    }
    public User(Connection con){
        this.con=con;
        ProgramUser();
    }
    private void ProgramUser(){

    }

    @Override
    public Connection getCon() {
        return super.getCon();
    }

    @Override
    public void setCon(Connection con) {
        super.setCon(con);
    }

    @Override
    public void show_ListCategory() {
        super.show_ListCategory();
    }

    @Override
    public void show_ListOption(int idClass) {
        super.show_ListOption(idClass);
    }

    @Override
    public List<Product> select_Products_FromOptions(int idClass, List<String> options, long[] price) {
        return super.select_Products_FromOptions(idClass, options, price);
    }
}
