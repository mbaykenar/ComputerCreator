public class Cpu extends Hardware {

  private double cacheSize;

  private double clockSpeed;

  private int coreNumber;

  private int threadNumber;
  
  private int maxTDP;

  private int lithography;

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
        String insertQuery = "INSERT INTO CPU ("+super.getModel()+","+super.getVendor()+"," + super.getPrice()+","
                +coreNumber+","+threadNumber+","+maxTDP+","+lithography+","+cacheSize+","+clockSpeed+")";
        Helper helper = new Helper();
        helper.st = helper.openConnection();
        helper.st.executeUpdate(insertQuery);
        helper.st.close();
    }
    
    public void retriveCpu(int id) throws Exception{
        String insertQuery = "SELECT FROM cpu WHERE id = "+id;
        Helper helper = new Helper();
        helper.st = helper.openConnection();
        helper.rs = helper.st.executeQuery(insertQuery);
        if(helper.rs.next()){
            super.setId(helper.rs.getInt("id"));
            super.setModel(helper.rs.getString("model"));
            super.setVendor(helper.rs.getString("vendor"));
            super.setPrice(helper.rs.getDouble("money"));
            threadNumber = helper.rs.getInt("thread_number");
            cacheSize = helper.rs.getDouble("cache_size");
            maxTDP = helper.rs.getInt("max_tdp");
            lithography = helper.rs.getInt("lithograhy");
            clockSpeed = helper.rs.getDouble("clock_speed");       
        }
        helper.st.close();
    }
    
    
}