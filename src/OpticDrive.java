public class OpticDrive extends ExternalDevice {

  private int Speed;

    public OpticDrive() {
    }

    public OpticDrive(int Speed, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.Speed = Speed;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
}