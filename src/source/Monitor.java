
package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Monitor extends ExternalDevice {

  private String resolution;

  private int refreshRate;

  private double screenSize;

    public Monitor() {
    }

    public Monitor(String resolution, int refreshRate, double screenSize, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.screenSize = screenSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public String getResolution() {
        return resolution;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
    
    public void insertMonitor() throws Exception{
        
        String insertQuery = "INSERT INTO monitor (model, vendor, interface, e_type, resolution, refresh_rate, screen_size, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + super.getConnectionInterface() + "," + super.getType() + "," +
                   resolution + "," + refreshRate + "," + screenSize + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveMonitor(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM monitor WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            super.setType(rs.getString("e_type"));
            super.setConnectionInterface(rs.getString("interface"));
            resolution = rs.getString("resolution");
            refreshRate = rs.getInt("refresh_rate");
            screenSize = rs.getDouble("screen_size");
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Monitor> retrieveAllMonitors() throws Exception{
        ArrayList<Monitor> monitors = new ArrayList<Monitor>();
        String retrieveQuery = "SELECT * FROM monitor";
        Monitor monitor;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            monitor = new Monitor();
            monitor.setId(rs.getInt("id"));
            monitor.setModel(rs.getString("model"));
            monitor.setVendor(rs.getString("vendor"));
            monitor.setPrice(rs.getDouble("price"));
            monitor.setType(rs.getString("e_type"));
            monitor.setConnectionInterface(rs.getString("interface"));
            monitor.setResolution(rs.getString("resolution"));
            monitor.setRefreshRate(rs.getInt("refresh_rate"));
            monitor.setScreenSize(rs.getDouble("screen_size"));
            
            monitors.add(monitor);
        }
        return monitors;
    }
    
     public void deleteMonitor() throws Exception{
        String deleteQuery = "DELETE FROM monitor WHERE id = " + this.getId();
        Helper.delete(deleteQuery);
    }

}
