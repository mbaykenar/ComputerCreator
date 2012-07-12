
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

public class User {

  private String address;
  
  private String username;

  private String password;

  private String name;

  private String surname;
  
  private String phone;
  
  private String email;
  
  private int role;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }
  
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User(String Address, String username, String password, String name, String surname, String phone, String email, int role) {
        this.address = Address;
        this.username= username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }
    
    public void insertUser(String address, String username, String password, String name, String surname, String phone, String email, String role) throws Exception{
        String insertQuery = "INSERT INTO users (userRole, fName, lName, username, passw, phone, email, address)"
                           + "VALUES ('"+role+"','"+name+"', '"+surname+"', '"+username+"', '"+getPasswordHash(password)+"', '"+phone+"', '"+phone+"', '"+email+"', '"+address+"')";
        Helper.insert(insertQuery);
    }
    
    /*
     * Genel amacli user retrive metodu
     */
    public void retriveUser(int id) throws Exception{
        String retrieveQuery =  "SELECT * FROM users WHERE id = " + id;
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            address = rs.getString("address"); 
            username = rs.getString("username");
            this.password = rs.getString("passw");
            this.name = rs.getString("name");
            this.surname = rs.getString("lName");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
            this.role = rs.getInt("userRole");
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    /*
     * Kullanici girisi icin
     * Pencere donen kullanicinin ismine ve rolune gore acilmali
     */
    public User authenticateUser(String username, String password) throws Exception{
        User user = null;
        String retrieveQuery =  "SELECT * FROM users WHERE username = "+username+" AND passw ="+getPasswordHash(password);
        ResultSet rs = Helper.retrieve(retrieveQuery);
        if(rs.next()){
            address = rs.getString("address"); 
            username = rs.getString("username");
            this.password = rs.getString("passw");
            this.name = rs.getString("name");
            this.surname = rs.getString("lName");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
            this.role = rs.getInt("userRole");
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
        return user;
    }
    
    public String getPasswordHash(String passwordToEncrypt) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // SHA-256 sadece bir ornek. Baska algoritmalar da secilebilir.
        messageDigest.update(passwordToEncrypt.getBytes());
        String encryptedPassword = new String(messageDigest.digest());
        return encryptedPassword;
    }
}