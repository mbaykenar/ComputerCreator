
package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Ssd extends Storage {

  private double writeSpeed;

  private double readSpeed;

    public Ssd() {
    }

    public Ssd(int id, double writeSpeed, double readSpeed, double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(id, capacity, ConnectionInterface, model, vendor, price);
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public void setReadSpeed(double readSpeed) {
        this.readSpeed = readSpeed;
    }

    public void setWriteSpeed(double writeSpeed) {
        this.writeSpeed = writeSpeed;
    }
    
    public void insertSsd() throws Exception{
        
        String insertQuery = "INSERT INTO sdd (model, vendor, capacity, interface, write_speed, read_speed, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getCapacity() + "," +
                   super.getConnectionInterface() + "," + writeSpeed + "," + readSpeed + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveSsd(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM sdd WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setCapacity(rs.getDouble("capacity"));
            super.setConnectionInterface(rs.getString("interface"));
            writeSpeed = rs.getInt("write_speed");
            readSpeed = rs.getDouble("read_speed");      
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Ssd> retrieveAllSsds() throws Exception{
        ArrayList<Ssd> ssds = new ArrayList<Ssd>();
        String retrieveQuery = "SELECT * FROM ssd";
        Ssd ssd;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            ssd = new Ssd();
            ssd.setId(rs.getInt("id"));
            ssd.setModel(rs.getString("model"));
            ssd.setVendor(rs.getString("vendor"));
            ssd.setPrice(rs.getDouble("price"));
            ssd.setCapacity(rs.getDouble("capacity"));
            ssd.setConnectionInterface(rs.getString("interface"));
            ssd.setWriteSpeed(rs.getInt("write_speed"));
            ssd.setReadSpeed(rs.getDouble("read_speed"));
            
            ssds.add(ssd);
        }
        return ssds;
    }
    
    public void deleteSsd() throws Exception{
        String deleteQuery = "DELETE FROM ssd WHERE id = " + this.getId();
        Helper.delete(deleteQuery);
    }
}
