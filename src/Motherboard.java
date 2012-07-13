
import java.sql.ResultSet;

public class Motherboard extends Hardware {

  private String socket;

  private int memorySlots;

  private int pciSlots;

  private int pciESlots;

  private int busInterface;

  private double frequency;

    public Motherboard() {
    }

    public Motherboard(String socket, int memorySlots, int pciSlots, int pciESlots, int busInterface, double frequency, String model, String vendor, double price) {
        super(model, vendor, price);
        this.socket = socket;
        this.memorySlots = memorySlots;
        this.pciSlots = pciSlots;
        this.pciESlots = pciESlots;
        this.busInterface = busInterface;
        this.frequency = frequency;
    }
    
    public int getBusInterface() {
        return busInterface;
    }

    public double getdouble() {
        return frequency;
    }

    public int getMemorySlots() {
        return memorySlots;
    }

    public int getPciESlots() {
        return pciESlots;
    }

    public int getPciSlots() {
        return pciSlots;
    }

    public String getSocket() {
        return socket;
    }

    public void setBusInterface(int busInterface) {
        this.busInterface = busInterface;
    }

    public void setdouble(double frequency) {
        this.frequency = frequency;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public void setPciESlots(int pciESlots) {
        this.pciESlots = pciESlots;
    }

    public void setPciSlots(int pciSlots) {
        this.pciSlots = pciSlots;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
    
    public void insertMotherboard() throws Exception{
        
        String insertQuery = "INSERT INTO motherboard (model, vendor, socket, memory_slots, pci_slots, pci_e_slots, bus_interface, frequency, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + memorySlots + "," + pciSlots + "," + pciESlots + "," + busInterface + "," + frequency + "," +
                super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveMotherboard(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM motherboard WHERE id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            socket = rs.getString("socket");
            memorySlots = rs.getInt("memory_slots");
            pciSlots = rs.getInt("pci_slots");
            pciESlots = rs.getInt("pci_e_slots");
            busInterface = rs.getInt("bus_interface");
            frequency = rs.getDouble("frequency");       
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
     public static void deleteMotherboard(int id) throws Exception{
        String deleteQuery = "DELETE FROM motherboard WHERE id = " + id;
        Helper.delete(deleteQuery);
    }
}