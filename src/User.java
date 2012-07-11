public class User extends AbstractUser {

  private String Address;

    public User(String Address, String username, String password, String name, String surname) {
        super(username, password, name, surname);
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}