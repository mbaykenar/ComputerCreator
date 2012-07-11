public class Storage extends Hardware {

  private DataSize capacity;

  private String ConnectionInterface;

    public Storage(DataSize capacity, String ConnectionInterface, String model, String vendor, double price) {
        super(model, vendor, price);
        this.capacity = capacity;
        this.ConnectionInterface = ConnectionInterface;
    }

    public String getConnectionInterface() {
        return ConnectionInterface;
    }

    public DataSize getCapacity() {
        return capacity;
    }

    public void setConnectionInterface(String ConnectionInterface) {
        this.ConnectionInterface = ConnectionInterface;
    }

    public void setCapacity(DataSize capacity) {
        this.capacity = capacity;
    }
         
}