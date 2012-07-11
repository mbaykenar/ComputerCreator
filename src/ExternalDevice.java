public class ExternalDevice extends Hardware {

  private String connectionInterface;

  private String type;

    public ExternalDevice(String connectionInterface, String type, String model, String vendor, double price) {
        super(model, vendor, price);
        this.connectionInterface = connectionInterface;
        this.type = type;
    }


    public String getConnectionInterface() {
        return connectionInterface;
    }

    public String getType() {
        return type;
    }

    public void setConnectionInterface(String connectionInterface) {
        this.connectionInterface = connectionInterface;
    }

    public void setType(String type) {
        this.type = type;
    }

}