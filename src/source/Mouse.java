package source;


import java.sql.ResultSet;

public class Mouse extends ExternalDevice {

    public Mouse() {
    }

    public Mouse(String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
    }
    
    public void insertMouse() throws Exception{
        
        String insertQuery = "INSERT INTO mouse (model, vendor, interface, e_type, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getConnectionInterface() + "," + super.getType() + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveMouse(int id) throws Exception{
        String retrieveQuery =  "SELECT * FROM mouse WHERE id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setConnectionInterface(rs.getString("interface"));
            super.setType(rs.getString("e_type"));    
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
     public static void deleteMouse(int id) throws Exception{
        String deleteQuery = "DELETE FROM mouse WHERE id = " + id;
        Helper.delete(deleteQuery);
    }

}