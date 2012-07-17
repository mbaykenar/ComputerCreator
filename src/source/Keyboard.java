package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Keyboard extends ExternalDevice {

  private String layout;

    public Keyboard() {
    }

    public Keyboard(String layout, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
    
    public void insertKeyboard() throws Exception{
        
        String insertQuery = "INSERT INTO keyboard (model, vendor, interface, e_type, layout, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getConnectionInterface() + "," + super.getType() + "," +
                   layout + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveKeyboard(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM keyboard WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setType(rs.getString("e_type"));
            super.setConnectionInterface(rs.getString("interface"));
            layout = rs.getString("layout");   
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Keyboard> retrieveAllKeyboards() throws Exception{
        String retrieveQuery = "SELECT * FROM keyboard";
        ArrayList<Keyboard> keyboards = new ArrayList<Keyboard>();
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            Keyboard keyboard = new Keyboard();
            keyboard.setId(rs.getInt("id"));
            keyboard.setModel(rs.getString("model"));
            keyboard.setVendor(rs.getString("vendor"));
            keyboard.setPrice(rs.getDouble("price"));
            keyboard.setType(rs.getString("e_type"));
            keyboard.setConnectionInterface(rs.getString("interface"));
            keyboard.setLayout(rs.getString("layout"));
            
            keyboards.add(keyboard);
        }
        return keyboards;
    }
    
     public static void deleteKeyboard(int id) throws Exception{
        String deleteQuery = "DELETE FROM keyboard WHERE id = " + id;
        Helper.delete(deleteQuery);
    }

}