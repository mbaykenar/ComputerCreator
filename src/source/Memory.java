
package source;


import java.sql.ResultSet;
import java.util.ArrayList;

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

    public double getFrequency() {
        return frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setFrequency(double frequency) {
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
     
     public static ArrayList<Memory> retrieveAllMemories() throws Exception{
        ArrayList<Memory> memories = new ArrayList<Memory>();
        String retrieveQuery = "SELECT * FROM memory";
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            Memory m = new Memory();
            m.setId(rs.getInt("id"));
            m.setModel(rs.getString("model"));
            m.setVendor(rs.getString("vendor"));
            m.setPrice(rs.getDouble("price"));
            m.setCapacity(rs.getDouble("capacity"));
            m.setMemoryType(rs.getString("memory_type"));
            m.setFrequency(rs.getDouble("frequency"));
            
            memories.add(m);
        } 
        return memories;
    }

}