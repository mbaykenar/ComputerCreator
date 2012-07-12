public class Monitor extends ExternalDevice {

  private int resolution;

  private int refreshRate;

  private int screenSize;

    public Monitor() {
    }

    public Monitor(int resolution, int refreshRate, int screenSize, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.screenSize = screenSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
  

}