public class Ssd extends Storage {

  private DataSize writeSpeed;

  private DataSize readSpeed;

    public Ssd(DataSize writeSpeed, DataSize readSpeed, DataSize capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(capacity, ConnectionInterface, model, vendor, price);
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
    }

    public DataSize getReadSpeed() {
        return readSpeed;
    }

    public DataSize getWriteSpeed() {
        return writeSpeed;
    }

    public void setReadSpeed(DataSize readSpeed) {
        this.readSpeed = readSpeed;
    }

    public void setWriteSpeed(DataSize writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

}