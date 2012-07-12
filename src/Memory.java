public class Memory extends Hardware {

  private double capacity;

  private String memoryType;

  private double frequency;

    public Memory() {
    }

    public Memory(double capacity, String memoryType, double frequency, String model, String vendor, double price) {
        super(model, vendor, price);
        this.capacity = capacity;
        this.memoryType = memoryType;
        this.frequency = frequency;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getdouble() {
        return frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setdouble(double frequency) {
        this.frequency = frequency;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

}