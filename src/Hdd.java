public class Hdd extends Storage {

  private int rpm;

  private double diameter;

    public Hdd(int rpm, double diameter, DataSize capacity, String ConnectionInterface, int id) {
        super(capacity, ConnectionInterface, id);
        this.rpm = rpm;
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getRpm() {
        return rpm;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
  
}