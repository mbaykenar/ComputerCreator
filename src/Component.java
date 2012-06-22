public class Component {
  /* {author=Hasan}*/


  private int id;

  private String Model;

  private String Vendor;

  private double Price;
  
  public Component(int id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public double getPrice() {
        return Price;
    }

    public String getVendor() {
        return Vendor;
    }

    public int getId() {
        return id;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public void setId(int id) {
        this.id = id;
    }
  
  

}