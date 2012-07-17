package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Hdd extends Storage {

  private int rpm;

  private double diameter;

    public Hdd() {
    }

    public Hdd(int rpm, double diameter, double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(capacity, ConnectionInterface, model, vendor, price);
        this.rpm = rpm;
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getRpm() {
        return rpm;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
    
    public void insertHdd() throws Exception{
        
        String insertQuery = "INSERT INTO hdd (model, vendor, capacity, interface, rpm, diameter, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getCapacity() + "," +
                   super.getConnectionInterface() + "," + rpm + "," + diameter + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveHdd(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM hdd WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setCapacity(rs.getDouble("capacity"));
            super.setConnectionInterface(rs.getString("interface"));
            rpm = rs.getInt("rpm");
            diameter = rs.getDouble("diameter");      
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Hdd> retrieveAllHdds() throws Exception{
        ArrayList<Hdd> hdds = new ArrayList<Hdd>();
        String retrieveQuery = "SELECT * FROM hdd";
        Hdd hdd;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            hdd = new Hdd();
            hdd.setId(rs.getInt("id"));
            hdd.setModel(rs.getString("model"));
            hdd.setVendor(rs.getString("vendor"));
            hdd.setPrice(rs.getDouble("price"));
            hdd.setCapacity(rs.getDouble("capacity"));
            hdd.setConnectionInterface(rs.getString("interface"));
            hdd.setRpm(rs.getInt("rpm"));
            hdd.setDiameter(rs.getDouble("diameter"));
            
            hdds.add(hdd);
        }
        return hdds;
    }
    
     public static void deleteHdd(int id) throws Exception{
        String deleteQuery = "DELETE FROM hdd WHERE id = " + id;
        Helper.delete(deleteQuery);
    }
  
}
