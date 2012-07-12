
import java.sql.ResultSet;

public class Ssd extends Storage {

  private double writeSpeed;

  private double readSpeed;

    public Ssd() {
    }

    public Ssd(double writeSpeed, double readSpeed, double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(capacity, ConnectionInterface, model, vendor, price);
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
    
    public void retriveSsd(int id) throws Exception{
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

}