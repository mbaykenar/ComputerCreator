public class Ssd extends Storage {

  private double writeSpeed;

  private double readSpeed;

    public Ssd() {
    }

    public Ssd(double writeSpeed, double readSpeed, double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(capacity, ConnectionInterface, model, vendor, price);
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public void setReadSpeed(double readSpeed) {
        this.readSpeed = readSpeed;
    }

    public void setWriteSpeed(double writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

}