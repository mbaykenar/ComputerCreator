
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class User {

  private String address;
  
  private String username;

  private String password;

  private String name;

  private String surname;
  
  private String phone;
  
  private String email;
  
  private int role;
  
  private ArrayList<Integer> productIDs;
  
  public enum Products{ MOTHERBOARD, CPU, GRAPHICS_CARD, MEMORY, HDD, SSD, KEYBOARD, MONITOR, MOUSE, OPERATING_SYSTEM, OPTIC_DRIVE, SPEAKER}
  
  public static final int PRODUCT_COUNT = 13;

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
    
    public ArrayList<Integer> getProductIDs(){
        return productIDs;
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
    
    public void setProductIDs(ArrayList<Integer> productIDs){
        this.productIDs = productIDs;
    }
    
    public void addProduct(int id){
        this.productIDs.add(id);
    }
    
    public void clearProducts(){
        this.productIDs = new ArrayList<Integer>();
    }

    public User() {
        this.productIDs = new ArrayList<Integer>();
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
        this.productIDs = new ArrayList<Integer>();
    }
    
    public void insertUser(String address, String username, String password, String name, String surname, String phone, String email, String role) throws Exception{
        String insertQuery = "INSERT INTO users (userRole, fName, lName, username, passw, phone, email, address)"
                           + "VALUES ('"+role+"','"+name+"', '"+surname+"', '"+username+"', '"+getPasswordHash(password)+"', '"+phone+"', '"+phone+"', '"+email+"', '"+address+"')";
        Helper.insert(insertQuery);
    }
    
    /*
     * 
     */
    public void updateUser(String address, String username, String password, String name, String surname, String phone, String email, String role) throws Exception{
        String updateQuery = "UPDATE INTO users "
                            + "SET userRole='"+role+"', fName='"+name+"', lName='"+surname+"', username='"+username+"', passw'"+getPasswordHash(password)+"', phone='"+phone+"', email='"+email+"', address='"+address+"')";
        Helper.update(updateQuery);
    }
    
    /*
     * Genel amacli user retrive metodu
     */
    public void retrieveUser(int id) throws Exception{
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
            
            retrieveProducts(id); //loads products of the user
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
        int id;
        if(rs.next()){
            address = rs.getString("address"); 
            this.username = rs.getString("username");
            this.password = rs.getString("passw");
            this.name = rs.getString("name");
            this.surname = rs.getString("lName");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
            this.role = rs.getInt("userRole");
            id = rs.getInt("id");
            
            retrieveProducts(id);
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
    
    //restores stored user products from database
    private void retrieveProducts(int id) throws Exception{
        String retrieveQuery = "SELECT * FROM user_component WHERE user_id = " + id;
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        
        if(rs.next()){
            addProduct(rs.getInt("motherboard_id"));
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    //stores users products to database
    public void storeProducts(int id) throws Exception{
        String storeQuery;
        
        for(int i = 0; i < productIDs.size(); i++){
            storeQuery = "INSERT INTO user_component (user_id, component_id)"
                    + "VALUES (" + id + "," + productIDs.get(i);
            
            Helper.insert(storeQuery);
        }
    }
    
    //deletes users products from database
    public void deleteProducts(int id) throws Exception{
        String deleteQuery = "DELETE FROM user_component WHERE user_id = " + id;       
         Helper.delete(deleteQuery);
    }
    
}