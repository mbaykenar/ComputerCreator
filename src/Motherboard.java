public class Motherboard extends Hardware {

  private String socket;

  private int memorySlots;

  private int pciSlots;

  private int pciESlots;

  private int busInterface;

  private Frequency frequency;

    public Motherboard(String socket, int memorySlots, int busInterface, Frequency frequency, int id) {
        super(id);
        this.socket = socket;
        this.memorySlots = memorySlots;
        this.busInterface = busInterface;
        this.frequency = frequency;
    }

    public int getBusInterface() {
        return busInterface;
    }

    public Frequency getFrequency() {
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

    public void setFrequency(Frequency frequency) {
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