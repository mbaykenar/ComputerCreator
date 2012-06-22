public class OpticDrive extends ExternalDevice {

  private int Speed;

    public OpticDrive(int Speed, String connectionInterface, String type, int id) {
        super(connectionInterface, type, id);
        this.Speed = Speed;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
}