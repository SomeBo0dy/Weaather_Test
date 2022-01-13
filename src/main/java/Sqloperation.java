import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sqloperation {
    //向数据库插入城市Location信息
    public static void addCity(Location city){
        String name = city.getName();
        String id = city.getId();
        String lat = city.getLat();
        String lon = city.getLon();
        String sql = "replace into city_location(name,id,lat,lon) values(?,?,?,?)";
        Connection conn = null;//和数据库取得连接
        PreparedStatement pstmt = null;		//创建statement
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name); //给占位符赋值
            pstmt.setString(2, id); //给占位符赋值
            pstmt.setString(3, lat); //给占位符赋值
            pstmt.setString(4, lon); //给占位符赋值
            pstmt.executeUpdate();			//执行
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            LinkDatabaseInsert.close(conn);
            LinkDatabaseInsert.close(pstmt);
        }
    }
    //向数据库插入城市天气信息
    public static void addWeather(String name, Date date, String tempMax, String tempMin, String textDay){
        String sql = "replace into city_dailyweather(name,date,tempMax,tempMin,textDay) values(?,?,?,?,?)";
        Connection conn = null;//和数据库取得连接
        PreparedStatement pstmt = null;		//创建statement
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name); //给占位符赋值
            pstmt.setString(2, String.valueOf(date)); //给占位符赋值
            pstmt.setString(3, tempMax); //给占位符赋值
            pstmt.setString(4, tempMin); //给占位符赋值
            pstmt.setString(5, textDay); //给占位符赋值
            pstmt.executeUpdate();			//执行
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            LinkDatabaseInsert.close(conn);
            LinkDatabaseInsert.close(pstmt);
        }
    }
    //向数据库插入城市ID信息
    public static void setID(String id,String name){
        String sql = "replace into city_id(id,name) values(?,?) ";
        Connection conn = null;//和数据库取得连接
        PreparedStatement pstmt = null;		//创建statement
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, id); //给占位符赋值
            pstmt.setString(2, name); //给占位符赋值
            pstmt.executeUpdate();			//执行
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            LinkDatabaseInsert.close(conn);
            LinkDatabaseInsert.close(pstmt);
        }
    }
    //从数据库获取城市与ID对应的名字
    public static String findCityName(String id){
        String sql = "select name from city_id where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name = null;
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()){
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
        return name;
    }
    //从数据库获取城市对应日期的天气信息
    public static DailyWeather getWeather(String name, Date date){
        String sql = "select * from city_dailyweather where name = ? and date = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DailyWeather dw= null;
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setDate(2,date);
            rs = (ResultSet) pstmt.executeQuery();
            String tempMax;
            String tempMin;
            String textDay;
            while (rs.next()){
                tempMax = rs.getString("tempMax");
                tempMin = rs.getString("tempMin");
                textDay = rs.getString("textDay");
                dw = new DailyWeather(name,date,tempMax,tempMin,textDay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
        return dw;
    }
    //从数据库获取城市的Location信息
    public static Location getLocation(String name){
         String sql = "select * from city_location where name = ?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         Location lc = null;
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = (ResultSet) pstmt.executeQuery();
            String id;
            String lat;
            String lon;
            while (rs.next()){
                id = rs.getString("id");
                lat = rs.getString("lat");
                lon = rs.getString("lon");
                lc = new Location(name,id,lat,lon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
        return lc;
    }
    //从数据库获取对应城市有记录的日期set
    public static List<java.util.Date> getCityDate(String name){
        String sql = "select date from city_dailyweather where name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<java.util.Date> list = new ArrayList<>();
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()){
                list.add(new java.util.Date(rs.getDate("date").getTime())) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
        return list;
    }
    //获取数据表中数据总条数
    public static int getTotal(String tableName){
        String sql = "select count(*) from " + tableName;//获取数据表中数据总条数；
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int total = -1;
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            rs.next();
            total = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
        return total;
    }
    //分页查询
    public static void getPage(String tableName,int pageSize, int currPage){
        String sql = "select * from " + tableName + " limit ?,?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name;
        java.util.Date date;
        String tempMax;
        String tempMin;
        String textDay;
        int total = getTotal(tableName);
        int totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        try {
            conn = LinkDatabaseInsert.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(2, pageSize);
            int ofs = pageSize * (currPage - 1);
            pstmt.setInt(1, ofs);
            rs = (ResultSet) pstmt.executeQuery();
            System.out.println("=========================================================");
            System.out.println("Page:"+currPage+'/'+ totalPage);
            System.out.println("=========================================================");
            while (rs.next()){
                name = rs.getString("name");
                date = rs.getDate("date");
                tempMax = rs.getString("tempMax");
                tempMin = rs.getString("tempMin");
                textDay = rs.getString("textDay");
                System.out.print('|' + name + '|');
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                System.out.print(simpleDateFormat.format(date) + '|');
                System.out.print("tempMax:" + tempMax + "℃" + '|');
                System.out.print("tempMin:" + tempMin + "℃" + '|');
                System.out.println("textDay:" + textDay + '|');
            }
            System.out.println("=========================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            LinkDatabaseInsert.close(pstmt);
            LinkDatabaseInsert.close(conn);		//必须关闭
        }
    }

}


