
import java.sql.ResultSet;

public class GraphicsCard extends Hardware {

  private double clockSpeed;

  private int coreNumber;

  private int interfaceWidth;

  private double textureFillRate;

  private double memorySize;

  private int maxTDP;

    public GraphicsCard() {
    }

    public GraphicsCard(double clockSpeed, int coreNumber, int interfaceWidth, double textureFillRate, double memorySize, String model, String vendor, double price) {
        super(model, vendor, price);
        this.clockSpeed = clockSpeed;
        this.coreNumber = coreNumber;
        this.interfaceWidth = interfaceWidth;
        this.textureFillRate = textureFillRate;
        this.memorySize = memorySize;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public int getInterfaceWidth() {
        return interfaceWidth;
    }

    public int getMaxTDP() {
        return maxTDP;
    }

    public double getMemorySize() {
        return memorySize;
    }

    public double getTextureFillRate() {
        return textureFillRate;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public void setInterfaceWidth(int interfaceWidth) {
        this.interfaceWidth = interfaceWidth;
    }

    public void setMaxTDP(int maxTDP) {
        this.maxTDP = maxTDP;
    }

    public void setMemorySize(double memorySize) {
        this.memorySize = memorySize;
    }

    public void setTextureFillRate(double textureFillRate) {
        this.textureFillRate = textureFillRate;
    }
    
    public void insertGraphicsCard() throws Exception{
        
        String insertQuery = "INSERT INTO graphicsCard (model, vendor, clock_speed, cores, interface_width, max_tdp, texture_fill_rate, memory_size, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + clockSpeed + "," + coreNumber + "," + interfaceWidth + "," + maxTDP + "," + textureFillRate + "," +
                memorySize + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveGraphicsCard(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM graphicsCard WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            clockSpeed = rs.getDouble("clock_speed");
            coreNumber = rs.getInt("cores");
            maxTDP = rs.getInt("max_tdp");
            interfaceWidth = rs.getInt("interface_width");
            textureFillRate = rs.getDouble("texture_fill_rate");
            memorySize = rs.getDouble("memory_size");       
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
}