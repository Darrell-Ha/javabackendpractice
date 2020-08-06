package JavaBackend.buoi7.Function;

import JavaBackend.buoi7.Target.CountingTImes_71_4;
import JavaBackend.buoi7.Target.EnumerateCar;
import JavaBackend.buoi7.Target.EnumerateOption;
import JavaBackend.buoi7.Target.InforSupplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MYSQLConnector {
    Connection con;
    /*
     *   Activity 71
     *   Function theo thứ tự từ 71.1 - 71.8
     *   Thư mục buoi7/Target chứa các class ohuc vụ yêu cầu đề bài
     */
    public MYSQLConnector(){

    }
    public MYSQLConnector(Connection con){
        this.con=con;
    }

    ////Activity 71.1 Liệt kê những DÒNG XE có số chỗ ngồi > 5
    public void EnumCar_ValidCondition_71_1(){
        String sql="SELECT Dongxe AS ten FROM dongxe WHERE SoChoNgoi>5";
        List<String> nameCar = new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                EnumerateCar enu = new EnumerateCar(rs.getString(1),null);
                nameCar.add(enu.getName());
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        System.out.println(" Danh sách những dòng xe có số chỗ ngồi trên 5 chỗ:");
        for (int i = 0; i< nameCar.size();i++){
            System.out.println((i+1)+": "+nameCar.get(i));
        }
        System.out.println();
    }

    ////Activity 71.2 Liệt kê thông tin nhà cung cấp
    public void InFor_Supplier_71_2(){
        List<InforSupplier> infors = new ArrayList<>();
        String sql = "SELECT ncc.MaNhaCC,ncc.TenNhaCC,ncc.DiaChi,ncc.SoDT,ncc.MaSoThue  FROM  nhacungcap ncc" +
                " LEFT OUTER JOIN dangkycungcap dkcc ON ncc.MaNhaCC=dkcc.MaNhaCC ,dongxe dx " +
                "WHERE dkcc.DongXe=dx.DongXe AND HangXe IN('Toyota','KIA') group by MaNhaCC";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                InforSupplier infor= new InforSupplier(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5));
                infors.add(infor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Danh sách cần tìm theo yêu cầu của 71.2: ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n","MaNhaCC","TenNhaCC","Địa chỉ","Số điện thoại","Mã số thuế");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        for(InforSupplier infor : infors){
            System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n",infor.getMaNCC(),infor.getNameSup(),infor.getAddress(),infor.getPhonenum(),infor.getMaSoThue());
            System.out.println("------------------------------------------------------------------------");
        }
    }


    /*
     *  71.3 Liệt kê thông tin nhà cung cấp được sắp xếp theo
     *                  + tăng dần theo tên nhà cung cấp
     *                  + giảm dần theo mã số thuế
     * :))) câu này em chưa hiểu rõ ý đồ của anh nên em để lại
     */

    public void InFor_Supllier_71_3(){

    }


    /*
     *  71.4 Đếm số lần đăng ký cung cấp phương tiện
     *          tương ứng cho từng nhà cung cấp
     *          với ngày BẮT ĐẦU cung cấp bắt đầu từ 20/11/2015
     */
    public void Count_71_4(){
        List<CountingTImes_71_4> counts = new ArrayList<>();
        String sql="SELECT ncc.MaNhaCC, ncc.TenNhaCC, Count(dkcc.MaNhaCC) dem FROM dangkycungcap dkcc " +
                "LEFT OUTER JOIN nhacungcap ncc ON ncc.MaNhaCC=dkcc.MaNhaCC " +
                "WHERE NgayBatDauCungCap>='2015-11-20' GROUP BY MaNhaCC";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                CountingTImes_71_4 count = new CountingTImes_71_4(rs.getString(1),rs.getString(2)
                        ,rs.getInt(3));
                counts.add(count);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Số lần đăng ký cung cấp phương tiện ở từng hãng kể từ ngày 20-11-2015:");
        System.out.println("--------------------------------------------");
        System.out.printf("|%-10s|%-28s|%-5s|\n","MaNCC","Tên nhà CC","Lần");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        for (CountingTImes_71_4 count :counts){
            System.out.printf("|%-10s|%-28s|%-5d|\n",count.getMaNCC(),count.getNameSup(),count.getDem());
            System.out.println("--------------------------------------------");
        }

    }


    ///71.5 Kể tên các hãng xe có trong cơ sở dữ liệu
    public void EnuNameCar_71_5(){
        String sql="SELECT DISTINCT HangXe FROM dongxe";
        List<String> names = new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                EnumerateCar namecar = new EnumerateCar(null,rs.getString(1));
                names.add(namecar.getNameNSX());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Danh sách các hãng xe có trong DB");
        for(String name : names){
            System.out.println(name);
        }

    }

    ///71.6 Liệt kê những yêu cầu theo đề bài
    public void EnuInfor_71_6(){
        String sql="SELECT dkcc.MaDKCC,dkcc.MaNhaCC,ncc.TenNhaCC,ncc.DiaChi,ncc.MaSoThue,dv.TenLoaiDV" +
                ",mp.DonGia,dkcc.NgayBatDauCungCap,dkcc.NgayKetThucCungCap " +
                "FROM mucphi mp,loaidichvu dv ,dangkycungcap dkcc LEFT OUTER JOIN nhacungcap ncc " +
                "ON ncc.MaNhaCC=dkcc.MaNhaCC " +
                "WHERE dkcc.MaLoaiDV=dv.MaLoaiDV AND dkcc.MaMP=mp.MaMP ORDER BY dkcc.MaDKCC ASC";
        List<EnumerateOption> options = new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                EnumerateOption option = new EnumerateOption(rs.getString(1),rs.getString(2)
                        ,rs.getString(3),rs.getString(4),rs.getString(5)
                        ,rs.getString(6),rs.getString(7),rs.getDate(8),rs.getDate(9));
                options.add(option);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Danh sách thực hiện theo yêu cầu");
        for (EnumerateOption enu :options){
            System.out.println(enu.toString());
        }

    }

    //71.7 Liệt kê thông tin nhà cung cấp đã từng đăng ký phương tiện thuộc 'Hiace' hoặc 'Cerato'
    public void inFor_Supplier_71_7(){
        List<InforSupplier> infors = new ArrayList<>();
        String sql = "SELECT ncc.MaNhaCC,ncc.TenNhaCC,ncc.DiaChi,ncc.SoDT,ncc.MaSoThue  " +
                "FROM nhacungcap ncc LEFT OUTER JOIN dangkycungcap dkcc ON ncc.MaNhaCC=dkcc.MaNhaCC" +
                " WHERE DongXe='Hiace' OR DongXe='Cerato' GROUP BY dkcc.MaNhaCC";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                InforSupplier infor= new InforSupplier(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5));
                infors.add(infor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Danh sách cần tìm theo yêu cầu của 71.7: ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n","MaNhaCC","TenNhaCC","Địa chỉ","Số điện thoại","Mã số thuế");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        for(InforSupplier infor : infors){
            System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n",infor.getMaNCC(),infor.getNameSup(),infor.getAddress(),infor.getPhonenum(),infor.getMaSoThue());
            System.out.println("------------------------------------------------------------------------");
        }
    }

    //71.8 Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp
    //phương tiện lần nào cả.
    public  void inFor_Supplier_71_8(){
        String sql ="SELECT * FROM nhacungcap ncc LEFT OUTER JOIN dangkycungcap dkcc ON ncc.MaNhaCC=dkcc.MaNhaCC ";
        List<InforSupplier>infors = new ArrayList<>();
        try{
            Statement stmt= con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String nameCar = rs.getString(12);
                if(nameCar==null){
                    InforSupplier infor = new InforSupplier(rs.getString(1),rs.getString(2)
                            ,rs.getString(3),rs.getString(4),rs.getString(5));
                    infors.add(infor);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Danh sách nhà cung cấp chưa đăng kí: ");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n","MaNhaCC","TenNhaCC","Địa chỉ","Số điện thoại","Mã số thuế");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
        for(InforSupplier infor : infors){
            System.out.printf("|%-10s|%-25s|%-15s|%-17s|\n",infor.getMaNCC(),infor.getNameSup(),infor.getAddress(),infor.getPhonenum(),infor.getMaSoThue());
            System.out.println("------------------------------------------------------------------------");
        }

    }

}
