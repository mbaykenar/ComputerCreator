public class Keyboard extends ExternalDevice {

  private String layout;

    public Keyboard(String layout, String connectionInterface, String type, String model, String vendor, double price) {
        super(connectionInterface, type, model, vendor, price);
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

}