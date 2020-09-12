package JavaBackend.Project.ConnectDB;

import JavaBackend.Project.Product.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DataBase {
    private Connection con;
    private HashMap<Integer,String> listCategory;
    private HashMap<Integer,List<String>>listOption_followedIDClass;
    public DataBase(){

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /*  Các hàm chung của Admin + User:
     *  Ý tưởng sử dụng các hàm:
     *
     *      show_ListCategory() dùng dể hiện thị + thêm dữ liệu về bảng phân chia loại sản phẩm (TV, Loa...) với idClass
     *      show_ListOption(idClass) sẽ thêm + hiển thị 1 số option cho người dùng chọn
     *      choose_Option() sẽ return ra 1 ArrayList<String> từ 1 LinkedList chứa các option
     *      select_Products sẽ list ra những sản phẩm tìm kiếm dc thông qua idClass + List<String>options=>>ArrayList
     */

    //public void
    public void show_ListCategory(){
        if(listCategory.isEmpty()) {
            String sql = "SELECT idClass,nameClass FROM CATEGORY";
            HashMap<Integer, String> list = new HashMap<>();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    list.put(rs.getInt(1), rs.getString(2));
                    System.out.println(rs.getInt(1)+": "+list.get(rs.getInt(1)));
                }
                this.listCategory=list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            for(int key :listCategory.keySet()){
                System.out.println(key+": "+listCategory.get(key));
            }
        }
    }
    public void show_ListOption(int idClass) {
        if (!listOption_followedIDClass.containsKey(idClass)){
            String sql = "SELECT * FROM CATEGORY WHERE idClass=" + idClass;
            List<String> listOption = new ArrayList<>();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                for (int i = 3; i < 13; i++) {
                    if (!rs.getString(i).isEmpty()) {
                        listOption.add(rs.getString(i));
                        System.out.println(rs.getString(i));
                    } else {
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.listOption_followedIDClass.put(idClass,listOption);
        }else {
            for (String option :listOption_followedIDClass.get(idClass)){
                System.out.println(option);
            }
        }
    }
    //public List<String> chooseOptions
    public List<Product> select_Products_FromOptions(int idClass, List<String> options, long[] price){
        String sql1 ="SELECT pro.idProd, pro.idClass, pro.priceUnit, pro.idDescription, pro.onlineDiscount, pro.nameProd," +
                "pro.detailDiscount, des.image,des.detail_infor " +
                "FROM PRODUCT pro, DESCRIPTION_PRODUCT des " +
                "WHERE pro.idDescription=des.idDescription AND pro.idClass="+idClass;
        List<Product> products = new ArrayList<>();
        HashMap<String,Product> pros= new HashMap<>();
        try{
            Statement stmt =con.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()){
                String [] getDetail_FromRS= rs.getString(9).split("@@@");
                long priceProduct=rs.getLong(3);
                List<String> detail= new ArrayList<>();
                for(String option : getDetail_FromRS){
                    detail.add(option);
                }
                if(detail.containsAll(options)){
                    if (price==null){
                        Product product = new Product(rs.getString(1),rs.getInt(2),null,
                                rs.getString(4),rs.getString(6),0
                                ,0,0,0,rs.getString(7),rs.getString(8),
                                rs.getString(9),rs.getString(5));
                        pros.put(product.getIdProd(),product);
                    }else if(priceProduct <price[1]+1 && priceProduct>price[0]-1){
                        Product product = new Product(rs.getString(1),rs.getInt(2),null,
                                rs.getString(4),rs.getString(6),rs.getLong(3)
                                ,0,0,0,rs.getString(7),rs.getString(8),
                                rs.getString(9),rs.getString(5));
                        pros.put(product.getIdProd(),product);
                    }
                }
            }
            String sql2 = "SELECT pro.idProd, quant.(storing-ordered) FROM PRODUCT pro, QUANTITY_PRODUCT quant " +
                    "WHERE pro.idQuantity=quant.idQuantity";
            try{
                ResultSet rs1= stmt.executeQuery(sql2);
                while (rs1.next()){
                    if(rs1.getInt(2)<0){
                        String idProd = rs1.getString(1);
                        pros.remove(idProd);
                    }
                }
                for (String idProd :pros.keySet()){
                    products.add(pros.get(idProd));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }


    public HashMap<Integer, String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(HashMap<Integer, String> listCategory) {
        this.listCategory = listCategory;
    }

    public HashMap<Integer, List<String>> getListOption_followedIDClass() {
        return listOption_followedIDClass;
    }

    public void setListOption_followedIDClass(HashMap<Integer, List<String>> listOption_followedIDClass) {
        this.listOption_followedIDClass = listOption_followedIDClass;
    }
}
