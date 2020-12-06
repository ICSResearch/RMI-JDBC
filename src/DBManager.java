import java.sql.*;
import java.util.Vector;

public class DBManager {
    private static final String userName = "root";
    private static final String password = "*Your password*";
    private static final String url = "jdbc:mysql://localhost:3306/rmidb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static Connection conn = null;
    static Statement stmt = null;

    public static boolean insertCar(int ID, String Brand, String Series, String Color, int Year, int Weight, int Price){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "insert into car values " +
                    "(" + ID + ", \"" + Brand + "\", \"" +
                    Series + "\", \"" + Color + "\", " + Year + ", " + Weight + ", " + Price + ")";
            System.out.println("Linking db, Receive sql: " + sql);
            stmt.execute(sql);

            stmt.close();
            conn.close();
            return true;
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
            return false;
        }
    }

    public static boolean insertReceipt(int ID, String Name){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "insert into receipt values " +
                    "(" + ID + ", \"" + Name + ")";
            System.out.println("Linking db, Receive sql: " + sql);
            stmt.execute(sql);

            stmt.close();
            conn.close();
            return true;
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
            return false;
        }
    }

    public static Car showCar_ID(int ID){
        Car car = new Car();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from car where ID = " + ID;
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println(rs);

            if (rs.next()){
                car.setID(rs.getInt(1));
                car.setBrand(rs.getString(2));
                car.setSeries(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setYear(rs.getInt(5));
                car.setWeight(rs.getInt(6));
                car.setPrice(rs.getInt(7));
            }
            else {
                stmt.close();
                conn.close();
                return null;
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return car;
    }

    public static Vector<Car> showCar_Brand(String Brand){
        Vector<Car> cars = new Vector<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from car where Brand = \"" + Brand + "\"";
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                do{
                    Car car = new Car();
                    car.setID(rs.getInt(1));
                    car.setBrand(rs.getString(2));
                    car.setSeries(rs.getString(3));
                    car.setColor(rs.getString(4));
                    car.setYear(rs.getInt(5));
                    car.setWeight(rs.getInt(6));
                    car.setPrice(rs.getInt(7));
                    cars.add(car);
                }while (rs.next());
            }
            else {
                stmt.close();
                conn.close();
                return null;
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return cars;
    }

    public static Receipt showReceipt_ID(int ID){
        Receipt receipt = new Receipt();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from receipt where ID = " + ID;
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
                receipt.setID(rs.getInt(1));
                receipt.setName(rs.getString(2));
            }else {
                stmt.close();
                conn.close();
                return null;
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return receipt;
    }

    public static Vector<Receipt> showReceipt_Name(String Name){
        Vector<Receipt> receipts = new Vector<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from receipt where Name = \"" + Name + "\"";
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                do{
                    Receipt receipt = new Receipt();
                    receipt.setID(rs.getInt(1));
                    receipt.setName(rs.getString(2));
                    receipts.add(receipt);
                }while (rs.next());
            }
            else {
                stmt.close();
                conn.close();
                return null;
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return receipts;
    }

    public static Vector<Car> showCars(){
        Vector<Car> cars = new Vector<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from car";
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs != null && rs.next()){
                Car car = new Car();
                car.setID(rs.getInt(1));
                car.setBrand(rs.getString(2));
                car.setSeries(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setYear(rs.getInt(5));
                car.setWeight(rs.getInt(6));
                car.setPrice(rs.getInt(7));
                cars.add(car);
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return cars;
    }

    public static Vector<Receipt> showReceipts(){
        Vector<Receipt> receipts = new Vector<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from receipt";
            System.out.println("Linking db, Receive sql: " + sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs != null && rs.next()){
                Receipt receipt = new Receipt();
                receipt.setID(rs.getInt(1));
                receipt.setName(rs.getString(2));
                receipts.add(receipt);
            }

            stmt.close();
            conn.close();
        }catch(SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
        return receipts;
    }
}
