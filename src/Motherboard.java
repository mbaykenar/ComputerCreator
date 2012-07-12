public class Motherboard extends Hardware {

  private String socket;

  private int memorySlots;

  private int pciSlots;

  private int pciESlots;

  private int busInterface;

  private double frequency;

    public Motherboard() {
    }

    public Motherboard(String socket, int memorySlots, int pciSlots, int pciESlots, int busInterface, double frequency, String model, String vendor, double price) {
        super(model, vendor, price);
        this.socket = socket;
        this.memorySlots = memorySlots;
        this.pciSlots = pciSlots;
        this.pciESlots = pciESlots;
        this.busInterface = busInterface;
        this.frequency = frequency;
    }
    
    public int getBusInterface() {
        return busInterface;
    }

    public double getdouble() {
        return frequency;
    }

    public int getMemorySlots() {
        return memorySlots;
    }

    public int getPciESlots() {
        return pciESlots;
    }

    public int getPciSlots() {
        return pciSlots;
    }

    public String getSocket() {
        return socket;
    }

    public void setBusInterface(int busInterface) {
        this.busInterface = busInterface;
    }

    public void setdouble(double frequency) {
        this.frequency = frequency;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public void setPciESlots(int pciESlots) {
        this.pciESlots = pciESlots;
    }

    public void setPciSlots(int pciSlots) {
        this.pciSlots = pciSlots;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
  

}