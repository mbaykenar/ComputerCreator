package source;


import java.sql.ResultSet;

public class Memory extends Hardware {

  private double capacity;

  private String memoryType;

  private double frequency;

    public Memory() {
    }

    public Memory(double capacity, String memoryType, double frequency, String model, String vendor, double price) {
        super(model, vendor, price);
        this.capacity = capacity;
        this.memoryType = memoryType;
        this.frequency = frequency;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getdouble() {
        return frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setdouble(double frequency) {
        this.frequency = frequency;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
    
    public void insertMemory() throws Exception{
        
        String insertQuery = "INSERT INTO memory (model, vendor, capacity, memory_type, frequency, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + capacity + "," +
                   memoryType + "," + frequency + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveMemory(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM memory WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            capacity = rs.getDouble("capacity");
            memoryType = rs.getString("memory_type");
            frequency = rs.getDouble("frequency");    
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
     public static void deleteMemory(int id) throws Exception{
        String deleteQuery = "DELETE FROM memory WHERE id = " + id;
        Helper.delete(deleteQuery);
    }

}