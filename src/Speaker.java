public class Speaker extends ExternalDevice {

  private int power;


    public Speaker(int power, String connectionInterface, String type, int id) {
        super(connectionInterface, type, id);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
  
}