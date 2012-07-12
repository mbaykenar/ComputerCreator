public class Component {
  /* {author=Hasan}*/


  private int id;

  private String model;

  private String vendor;

  private double price;

    public Component() {
    }

    public Component(String model, String vendor, double price) {
        this.model = model;
        this.vendor = vendor;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getVendor() {
        return vendor;
    }

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setId(int id) {
        this.id = id;
    }

}