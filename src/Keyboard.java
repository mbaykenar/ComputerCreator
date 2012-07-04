public class Keyboard extends ExternalDevice {

  private String layout;

    public Keyboard(String layout, String connectionInterface, String type, int id) {
        super(connectionInterface, type, id);
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

}