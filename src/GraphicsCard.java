public class GraphicsCard extends Hardware {

  private Frequency clockSpeed;

  private int coreNumber;

  private int interfaceWidth;

  private int textureFillRate;

  private DataSize memorySize;

  private int maxTDP;

    public GraphicsCard(Frequency clockSpeed, int coreNumber, int interfaceWidth, int textureFillRate, DataSize memorySize, int id) {
        super(id);
        this.clockSpeed = clockSpeed;
        this.coreNumber = coreNumber;
        this.interfaceWidth = interfaceWidth;
        this.textureFillRate = textureFillRate;
        this.memorySize = memorySize;
    }

    public Frequency getClockSpeed() {
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

    public DataSize getMemorySize() {
        return memorySize;
    }

    public int getTextureFillRate() {
        return textureFillRate;
    }

    public void setClockSpeed(Frequency clockSpeed) {
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

    public void setMemorySize(DataSize memorySize) {
        this.memorySize = memorySize;
    }

    public void setTextureFillRate(int textureFillRate) {
        this.textureFillRate = textureFillRate;
    }
}