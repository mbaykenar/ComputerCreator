package source;

public class Storage extends Hardware {

  private double capacity;

  private String ConnectionInterface;

    public Storage() {
    }

    public Storage(double capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(model, vendor, price);
        this.capacity = capacity;
        this.ConnectionInterface = ConnectionInterface;
    }

    public String getConnectionInterface() {
        return ConnectionInterface;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setConnectionInterface(String ConnectionInterface) {
        this.ConnectionInterface = ConnectionInterface;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
         
}