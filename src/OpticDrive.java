
import java.sql.ResultSet;

public class OpticDrive extends ExternalDevice {

  private int speed;

    public OpticDrive() {
    }

    public OpticDrive(int Speed, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.speed = Speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int Speed) {
        this.speed = Speed;
    }
    
    public void insertOpticDrive() throws Exception{
        
        String insertQuery = "INSERT INTO opticDrive (model, vendor, interface, e_type, speed, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getConnectionInterface() + "," + super.getType() + "," + speed + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveOpticDrive(int id) throws Exception{
        String retrieveQuery =  "SELECT * FROM opticDrive WHERE id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setConnectionInterface(rs.getString("interface"));
            super.setType(rs.getString("e_type"));    
            speed = rs.getInt("speed");
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
}