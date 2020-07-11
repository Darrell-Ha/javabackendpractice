package JavaBackend.buoi2.database.services;

import JavaBackend.buoi2.database.models.Counter;
import JavaBackend.buoi2.database.models.LaptopEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopServices {
    private Connection con;
    public LaptopServices(){

    }
    public LaptopServices(Connection connection){
        this.con=connection;
    }
    private List<LaptopEntity>querydatabase(String sql){
        List<LaptopEntity>laptopEntities=new ArrayList<>();
        try{
            Statement stmt =con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                LaptopEntity laptopEntity= new LaptopEntity(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getFloat(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getTimestamp(15),
                        rs.getTimestamp(16));
                laptopEntities.add(laptopEntity);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return laptopEntities;
    }
    public List<LaptopEntity> find_all_by_Maker(String maker){
        String sql="SELECT * FROM laptop WHERE maker ='"+maker+"'";
        List<LaptopEntity> laptopEntities = querydatabase(sql);
        return laptopEntities;
    }

    ////// Activity 32///////
    public List<LaptopEntity>search_Laptop(Float fromPrice, Float toPrice, String maker, String screenSize,
                                           String ram, String cpu, String hdd, String ssd, String type, String card, String order){
        String sql ="SELECT * FROM laptop WHERE TRUE";
        if(fromPrice != null){
            sql += " AND price >="+ fromPrice;
        }
        if(toPrice != null){
            sql += " AND price <=" + toPrice;
        }
        if(maker != null){
            sql += " AND maker='" + maker +"'";
        }
        if(screenSize != null){
            sql += " AND screen_resolution='" + screenSize + "'";
        }
        if(ram != null){
            sql += " AND ram='" + ram + "'";
        }
        if(cpu != null){
            sql += " AND cpu LIKE '%" + cpu + "%'";
        }
        if(hdd != null){
            sql += " AND hdd='" + hdd + "'";
        }
        if(ssd != null){
            sql += " AND ssd='" + ssd +"'";
        }
        if(type != null){
            sql += " AND type='" + type + "'";
        }
        if(card != null){
            sql += " AND card='" + card + "'";
        }
        if(order != null){
            if(order.equals("DESC")){
                sql += " ORDER BY price DESC";
            } else {
                sql += " ORDER BY price ASC";
            }
        }
        List<LaptopEntity>laptopEntities =querydatabase(sql);
        return laptopEntities;
    }



    ////////tìm kiếm laptop theo khoảng giá/////// activity 31.1

    public List<LaptopEntity> find_by_price(Long fromPrice,Long toPrice){
        String sql="";
        if(fromPrice!=null && toPrice==null){
            sql="SELECT * FROM laptop WHERE price>="+fromPrice;
        }else if(fromPrice==null && toPrice!=null){
            sql = "SELCET * FROM laptop WHERE price<=" + toPrice;
        }else if(fromPrice != null && toPrice != null){
            sql = "SELECT * FROM laptop WHERE price BETWEEN " + fromPrice + " AND " + toPrice;
        }
        List<LaptopEntity> laptopEntities = querydatabase(sql);
        return laptopEntities;
    }

    /////tìm kiếm laptop theo loại ổ cứng và hãng sản xuất////// Activity 31.2
    public  List<LaptopEntity> find_by_maker_or_by_hardware (String maker,String hdd, String ssd){
        String sql="SELECT * FROM laptop WHERE TRUE ";
        if(maker!=null){
            sql+="AND maker='"+maker+"'";
        }
        if(hdd!=null){
            sql+="AND hdd='"+hdd+"'";
        }if(ssd!=null){
            sql+="AND ssd='"+ssd+"'";
        }
        List<LaptopEntity>laptopEntities =querydatabase(sql);
        return laptopEntities;
    }

    /////Tìm kiếm theo số lượng bán và sắp xếp theo chiều giảm dần Activity 33///
    public List<LaptopEntity> find_number_Maxsold_and_arrangeValueSold(){
        System.out.println("Top seller laptop");
        String sql="SELECT * FROM laptop ORDER BY sold DESC";
        List<LaptopEntity> laptopEntities=querydatabase(sql);
        return laptopEntities;
    }


    ////Thống kê số lượng máy tính của các hãng theo số lượng giảm dần Activity 41
        ///+ Thống kê số tiền thu được  Activity 42
    public List<Counter>getCounters_and_Statistics_byMaker(){
        List<Counter>counters=new ArrayList<>();
        try{
            Statement stmt =con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT maker, SUM(sold) AS quantity,SUM(sold*price) AS totalmoney FROM laptop GROUP BY maker ORDER BY quantity DESC");
            while(rs.next()){
                Counter counter = new Counter(rs.getString(1),rs.getInt(2),rs.getLong(3));
                counters.add(counter);
            }

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return counters;
    }


}
