package source;


import java.sql.ResultSet;
import java.util.ArrayList;

public class Motherboard extends Hardware {

  private String socket;

  private int memorySlots;

  private int pciSlots;

  private int pciESlots;

  private String busInterface;

  private double frequency;
  
  private ArrayList<Integer> matchedCpuIDs;
  
  private ArrayList<Integer> matchedGpuIDs;
  
  private ArrayList<Integer> matchedMemoryIDs;
  
  private ArrayList<Integer> matchedStorageIDs;


    public Motherboard() {
    }

    public Motherboard(String socket, int memorySlots, int pciSlots, int pciESlots, String busInterface, double frequency, String model, String vendor, double price) {
        super(model, vendor, price);
        this.socket = socket;
        this.memorySlots = memorySlots;
        this.pciSlots = pciSlots;
        this.pciESlots = pciESlots;
        this.busInterface = busInterface;
        this.frequency = frequency;
    }
    
    public String getBusInterface() {
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
    
    public ArrayList<Integer> getMatchedCpuIDs() {
        return matchedCpuIDs;
    }

    public ArrayList<Integer> getMatchedGpuIDs() {
        return matchedGpuIDs;
    }

    public ArrayList<Integer> getMatchedMemoryIDs() {
        return matchedMemoryIDs;
    }

    public ArrayList<Integer> getMatchedStorageIDs() {
        return matchedStorageIDs;
    }

    public void setBusInterface(String busInterface) {
        this.busInterface = busInterface;
    }

    public void setFrequency(double frequency) {
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
    
    public void setMatchedCpuIDs(ArrayList<Integer> matchedCpuIDs) {
        this.matchedCpuIDs = matchedCpuIDs;
    }

    public void setMatchedGpuIDs(ArrayList<Integer> matchedGpuIDs) {
        this.matchedGpuIDs = matchedGpuIDs;
    }

    public void setMatchedMemoryIDs(ArrayList<Integer> matchedMemoryIDs) {
        this.matchedMemoryIDs = matchedMemoryIDs;
    }

    public void setMatchedSorageIDs(ArrayList<Integer> matchedSorageIDs) {
        this.matchedStorageIDs = matchedSorageIDs;
    }
    
    public void addCpu(int id){
        this.matchedCpuIDs.add(id);
    }
    
    public void addGpu(int id){
        this.matchedGpuIDs.add(id);
    }
    
    public void addMemory(int id){
        this.matchedMemoryIDs.add(id);
    }
    
    public void addStorage(int id){
        this.matchedStorageIDs.add(id);
    }
    
    public void clearMatchedCpus(){
        this.matchedCpuIDs = new ArrayList<Integer>();
    }
    
    public void clearMatchedGpus(){
        this.matchedCpuIDs = new ArrayList<Integer>();
    }
    
    public void clearMatchedMemories(){
        this.matchedCpuIDs = new ArrayList<Integer>();
    }
    
    public void clearMatchedStorages(){
        this.matchedCpuIDs = new ArrayList<Integer>();
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
            busInterface = rs.getString("bus_interface");
            frequency = rs.getDouble("frequency");       
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public static ArrayList<Motherboard> retrieveAllMotherboards() throws Exception{
        ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
        String retrieveQuery = "SELECT * FROM motherboard";
        Motherboard mb;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            mb = new Motherboard();
            mb.setId(rs.getInt("id"));
            mb.setModel(rs.getString("model"));
            mb.setVendor(rs.getString("vendor"));
            mb.setPrice(rs.getDouble("price"));
            mb.setSocket(rs.getString("socket"));
            mb.setMemorySlots(rs.getInt("memory_slots"));
            mb.setPciSlots(rs.getInt("pci_slots"));
            mb.setPciESlots(rs.getInt("pci_e_slots"));
            mb.setBusInterface(rs.getString("bus_interface"));
            mb.setFrequency(rs.getDouble("frequency"));
            
            motherboards.add(mb);
        } 
        return motherboards;
    }
    
    public static void deleteMotherboard(int id) throws Exception{
       String deleteQuery = "DELETE FROM motherboard WHERE id = " + id;
       Helper.delete(deleteQuery);
    }
    
    public void retrieveCpuMatches(int mbId) throws Exception{
        String matchQuery = "SELECT cpu_id FROM cpu_motherboard WHERE motherboard_id="+mbId;
        ResultSet rs = Helper.retrieve(matchQuery);
        while(rs.next()){
            addCpu(rs.getInt("cpu_id"));
        }
    }
    
    public void retrieveGpuMatches(int mbId) throws Exception{
        String matchQuery = "SELECT gpu_id FROM gpu_motherboard WHERE motherboard_id="+mbId;
        ResultSet rs = Helper.retrieve(matchQuery);
        while(rs.next()){
            addGpu(rs.getInt("gpu_id"));
        }
    }
    
    public void retrieveMemoryMatches(int mbId) throws Exception{
        String matchQuery = "SELECT memory_id FROM memory_motherboard WHERE motherboard_id="+mbId;
        ResultSet rs = Helper.retrieve(matchQuery);
        while(rs.next()){
            addMemory(rs.getInt("memory_id"));
        }
    }
    
    public void retrieveStorageMatches(int mbId) throws Exception{
        String matchQuery = "SELECT storage_id FROM storage_motherboard WHERE motherboard_id="+mbId;
        ResultSet rs = Helper.retrieve(matchQuery);
        while(rs.next()){
            addMemory(rs.getInt("storage_id"));
        }
    }
    
    //stores cpu matches
    public void storeCpuMatches() throws Exception{
        String storeQuery = "INSERT INTO cpu_motherboard (cpu_id, motherboard_id)" +
                "VALUES (";
        
        for(int i = 0; i < matchedCpuIDs.size(); i++){
            String tempQuery = storeQuery;
            tempQuery = tempQuery + matchedCpuIDs.get(i) + "," + this.getId() + ")";
        
            Helper.insert(tempQuery);
        }
            
    }
    
    //stores gpu matches
    public void storeGpuMatches() throws Exception{
        String storeQuery = "INSERT INTO gpu_motherboard (gpu_id, motherboard_id)" +
                "VALUES (";
        
        for(int i = 0; i < matchedGpuIDs.size(); i++){
            String tempQuery = storeQuery;
            tempQuery = tempQuery + matchedGpuIDs.get(i) + "," + this.getId() + ")";
        
            Helper.insert(tempQuery);
        }
            
    }
    
    //stores memory matches
    public void storeMemoryMatches() throws Exception{
        String storeQuery = "INSERT INTO memory_motherboard (memory_id, motherboard_id)" +
                "VALUES (";
        
        for(int i = 0; i < matchedMemoryIDs.size(); i++){
            String tempQuery = storeQuery;
            tempQuery = tempQuery + matchedMemoryIDs.get(i) + "," + this.getId() + ")";
        
            Helper.insert(tempQuery);
        }
            
    }
    
    //stores storage matches
    public void storeStorageMatches() throws Exception{
        String storeQuery = "INSERT INTO storage_motherboard (storage_id, motherboard_id)" +
                "VALUES (";
        
        for(int i = 0; i < matchedStorageIDs.size(); i++){
            String tempQuery = storeQuery;
            tempQuery = tempQuery + matchedStorageIDs.get(i) + "," + this.getId() + ")";
        
            Helper.insert(tempQuery);
        }
            
    }
}
