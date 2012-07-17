package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class OperatingSystem extends Software {

    public OperatingSystem() {
    }

    public OperatingSystem(String version, String platform, String model, String vendor, double price) {
        super(version, platform, model, vendor, price);
    }
    
    public void insertOperatingSystem() throws Exception{
        
        String insertQuery = "INSERT INTO operatingSystem (model, vendor, s_version, platform, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getVersion() + "," + super.getPlatform() + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveOperatingSystem(int id) throws Exception{
        String retrieveQuery =  "SELECT * FROM operatingSystem WHERE id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setPlatform(rs.getString("platform"));
            super.setVersion(rs.getString("s_version"));    
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<OperatingSystem> retrieveAllOperatingSystems() throws Exception{
        ArrayList<OperatingSystem> operatingSystems = new ArrayList<OperatingSystem>();
        String retrieveQuery = "SELECT * FROM operatingSystem";
        OperatingSystem operatingSystem;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            operatingSystem = new OperatingSystem();
            operatingSystem.setId(rs.getInt("id"));
            operatingSystem.setModel(rs.getString("model"));
            operatingSystem.setVendor(rs.getString("vendor"));
            operatingSystem.setPrice(rs.getDouble("price"));
            operatingSystem.setPlatform(rs.getString("platform"));
            operatingSystem.setVersion(rs.getString("s_version"));
            
            operatingSystems.add(operatingSystem);
        }
        return operatingSystems;
    }
    
     public static void deleteOperatingSystem(int id) throws Exception{
        String deleteQuery = "DELETE FROM operatingSystem WHERE id = " + id;
        Helper.delete(deleteQuery);
    }

}