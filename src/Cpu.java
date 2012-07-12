import java.sql.ResultSet;

public class Cpu extends Hardware {

  private double cacheSize;

  private double clockSpeed;

  private int coreNumber;

  private int threadNumber;
  
  private int maxTDP;

  private int lithography;

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
    
    public void insertCpu() throws Exception{
        
        String insertQuery = "INSERT INTO cpu (model, vendor, cores, threads, max_tdp, lithography, cache_size, clock_speed, price)" +
            "VALUES ('" + super.getModel() + "'," + "'" + super.getVendor() + "'," + coreNumber + "," + threadNumber + "," + maxTDP + "," + lithography + "," + cacheSize + "," +
                clockSpeed + "," + super.getPrice() + ")";
        Helper.insert(insertQuery);
    }
    
    public void retriveCpu(int id) throws Exception{
        String insertQuery = "SELECT * FROM cpu WHERE id = "+id;
        //Helper helper = new Helper();
        //helper.st = helper.openConnection();
        ResultSet rs = Helper.retrieve(insertQuery);
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
    
    
}
