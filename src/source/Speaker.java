
package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Speaker extends ExternalDevice {

  private int power;

    public Speaker() {
    }

    public Speaker(int power, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public void insertSpeaker() throws Exception{
        
        String insertQuery = "INSERT INTO speaker (model, vendor, interface, e_type, power, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getConnectionInterface() + "," + super.getType() + "," + power + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveSpeaker(int id) throws Exception{
        String retrieveQuery =  "SELECT * FROM speaker WHERE id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setConnectionInterface(rs.getString("interface"));
            super.setType(rs.getString("e_type"));    
            power = rs.getInt("power");
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Speaker> retrieveAllSpeakers() throws Exception{
        ArrayList<Speaker> speakers = new ArrayList<Speaker>();
        String retrieveQuery = "SELECT * FROM speaker";
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            Speaker speaker = new Speaker();
            speaker.setId(rs.getInt("id"));
            speaker.setModel(rs.getString("model"));
            speaker.setVendor(rs.getString("vendor"));
            speaker.setPrice(rs.getDouble("price"));
            speaker.setConnectionInterface(rs.getString("interface"));
            speaker.setType(rs.getString("e_type"));    
            speaker.setPower(rs.getInt("power"));
            
            speakers.add(speaker);
        }
        return speakers;
    }
    
     public static void deleteSpeaker(int id) throws Exception{
        String deleteQuery = "DELETE FROM speaker WHERE id = " + id;
        Helper.delete(deleteQuery);
    }
  
}