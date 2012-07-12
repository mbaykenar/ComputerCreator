public class GraphicsCard extends Hardware {

  private double clockSpeed;

  private int coreNumber;

  private int interfaceWidth;

  private int textureFillRate;

  private double memorySize;

  private int maxTDP;

    public GraphicsCard() {
    }

    public GraphicsCard(double clockSpeed, int coreNumber, int interfaceWidth, int textureFillRate, double memorySize, String model, String vendor, double price) {
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

    public int getTextureFillRate() {
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

    public void setTextureFillRate(int textureFillRate) {
        this.textureFillRate = textureFillRate;
    }
}