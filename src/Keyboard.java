
import java.sql.ResultSet;

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
    
    public void retriveKeyboard(int id) throws Exception{
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

}