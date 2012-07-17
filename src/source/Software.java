package source;

public class Software extends Component {

  private String version;

  private String platform;

    public Software() {
    }

    public Software(int id, String version, String platform, String model, String vendor, double price) {
        super(id, model, vendor, price);
        this.version = version;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public String getVersion() {
        return version;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}