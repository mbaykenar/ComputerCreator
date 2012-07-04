public class Cpu extends Hardware {

  private DataSize cacheSize;

  private Frequency clockSpeed;

  private int coreNumber;

  private int threadNumber;
  
  private int maxTDP;

  private int lithography;

    public Cpu(DataSize cacheSize, Frequency clockSpeed, int coreNumber, int threadNumber, int id) {
        super(id);
        this.cacheSize = cacheSize;
        this.clockSpeed = clockSpeed;
        this.coreNumber = coreNumber;
        this.threadNumber = threadNumber;
    }

    public DataSize getCacheSize() {
        return cacheSize;
    }

    public Frequency getClockSpeed() {
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

    public void setCacheSize(DataSize cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setClockSpeed(Frequency clockSpeed) {
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

  

}