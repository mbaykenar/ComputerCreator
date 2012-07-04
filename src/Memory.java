public class Memory extends Hardware {

  private DataSize capacity;

  private String memoryType;

  private Frequency frequency;

    public Memory(DataSize capacity, String memoryType, Frequency frequency, int id) {
        super(id);
        this.capacity = capacity;
        this.memoryType = memoryType;
        this.frequency = frequency;
    }

    public DataSize getCapacity() {
        return capacity;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setCapacity(DataSize capacity) {
        this.capacity = capacity;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

}