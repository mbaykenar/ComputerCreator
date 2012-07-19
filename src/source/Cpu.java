
package source;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Cpu extends Hardware {

  private double cacheSize;

  private double clockSpeed;

  private int coreNumber;

  private int threadNumber;
  
  private int maxTDP;

  private int lithography;
  
  private ArrayList<Integer> matchedMotherboardIDs;

    public Cpu() {
    }

    public Cpu(double cacheSize, double clockSpeed, int coreNumber, int threadNumber, String model, String vendor, double price) {
        super(model, vendor, price);
        this.cacheSize = cacheSize;
        this.clockSpeed = clockSpeed;
        this.coreNumber = coreNumber;
        this.threadNumber = threadNumber;
    }

    public double getCacheSize() {
        return cacheSize;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public int getLithography() {
        return lithography;
    }

    public int getMaxTDP() {
        return maxTDP;
    }

    public int getThreadNumber() {
        return threadNumber;
    }
    
    public ArrayList<Integer> getMatchedMotherBoardIDs() {
        return matchedMotherboardIDs;
    }

    public void setCacheSize(double cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public void setLithography(int lithography) {
        this.lithography = lithography;
    }

    public void setMaxTDP(int maxTDP) {
        this.maxTDP = maxTDP;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    public void setMatchedMotherBoardIDs(ArrayList<Integer> matchedMotherBoardIDs) {
        this.matchedMotherboardIDs = matchedMotherBoardIDs;
    }
    
    public void addMotherboard(int id){
        this.matchedMotherboardIDs.add(id);
    }
    
    public void clearMatchedMotherboards(){
        this.matchedMotherboardIDs = new ArrayList<Integer>();
    }
    
    public void retriveMatchedMotherboards(int id) throws Exception{
        String matchQuery = "SELECT motherboard_id FROM cpu_motherboard WHERE cpu_id="+id;
        ResultSet rs = Helper.retrieve(matchQuery);
        while(rs.next()){
            addMotherboard(rs.getInt("cpu_id"));
        }
    }
    
    public void insertCpu() throws Exception{
        
        String insertQuery = "INSERT INTO cpu (model, vendor, cores, threads, max_tdp, lithography, cache_size, clock_speed, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + coreNumber + "," + threadNumber + "," + maxTDP + "," + lithography + "," + cacheSize + "," +
                clockSpeed + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retrieveCpu(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM cpu WHERE id = "+id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            threadNumber = rs.getInt("threads");
            cacheSize = rs.getDouble("cache_size");
            maxTDP = rs.getInt("max_tdp");
            coreNumber = rs.getInt("cores");
            lithography = rs.getInt("lithography");
            clockSpeed = rs.getDouble("clock_speed");       
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public void retrieveCpu(String model) throws Exception{
        String retrieveQuery = "SELECT * FROM cpu WHERE model = '"+model + "'";
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            super.setId(rs.getInt("id"));
            super.setModel(rs.getString("model"));
            super.setVendor(rs.getString("vendor"));
            super.setPrice(rs.getDouble("price"));
            threadNumber = rs.getInt("threads");
            cacheSize = rs.getDouble("cache_size");
            maxTDP = rs.getInt("max_tdp");
            coreNumber = rs.getInt("cores");
            lithography = rs.getInt("lithography");
            clockSpeed = rs.getDouble("clock_speed");       
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    public void deleteCpu() throws Exception{
        String deleteQuery = "DELETE FROM cpu WHERE id = " + this.getId();
        Helper.delete(deleteQuery);
    }
    
    public static ArrayList<Cpu> retrieveAllCpus() throws Exception{
        ArrayList<Cpu> cpus = new ArrayList<Cpu>();
        String retrieveQuery = "SELECT * FROM cpu";
        ResultSet rs = Helper.retrieve(retrieveQuery);
        while(rs.next()){
            Cpu c = new Cpu();
            c.setId(rs.getInt("id"));
            c.setModel(rs.getString("model"));
            c.setVendor(rs.getString("vendor"));
            c.setPrice(rs.getDouble("price"));
            c.setCacheSize(rs.getDouble("cache_size"));
            c.setClockSpeed(rs.getDouble("clock_speed"));
            c.setCoreNumber(rs.getInt("cores"));
            c.setThreadNumber(rs.getInt("threads"));
            c.setLithography(rs.getInt("lithography"));
            c.setMaxTDP(rs.getInt("max_tdp"));
            
            cpus.add(c);
        } 
        return cpus;
    }
}
