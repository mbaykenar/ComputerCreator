public class DataSize {

  public enum UnitType{B, KB, MB, GB, TB}

  private double magnitude;
  UnitType type;

    public DataSize(double magnitude, UnitType type) {
        this.magnitude = magnitude;
        this.type = type;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public UnitType getType() {
        return type;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

}