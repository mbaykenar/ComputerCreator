public class Hdd extends Storage {

  private int rpm;

  private double diameter;

    public Hdd() {
    }

    public Hdd(int rpm, double diameter, double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(capacity, ConnectionInterface, model, vendor, price);
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