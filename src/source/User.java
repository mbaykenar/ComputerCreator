package source;


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
  
  private int userID;
  
  private ArrayList<Integer> productIDs;
  
  public enum Products{ MOTHERBOARD, CPU, GRAPHICS_CARD, MEMORY, HDD, SSD, KEYBOARD, MONITOR, MOUSE, OPERATING_SYSTEM, OPTIC_DRIVE, SPEAKER}
  
  public static final int PRODUCT_COUNT = 12;

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
    
    public int getUserID() {
        return userID;
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
    
    public void setUserID(int userID) {
        this.userID = userID;
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
    
    public void insertUser(String address, String username, String password, String name, String surname, String phone, String email, int role) throws Exception{
        String insertQuery = "INSERT INTO users (user_role, f_name, l_name, username, passw, phone, email, address)"
                           + "VALUES ("+role+",'"+name+"', '"+surname+"', '"+username+"', '"+getPasswordHash(password)+"', '"+phone+ "', '"+email+"', '"+address+"')";
        Helper.insert(insertQuery);
    }
    
    /*
     * 
     */
    public void updateUser(String address, String username, String password, String name, String surname, String phone, String email, String role) throws Exception{
        String updateQuery = "UPDATE INTO users "
                            + "SET user_role='"+role+"', f_name='"+name+"', l_name='"+surname+"', username='"+username+"', passw'"+getPasswordHash(password)+"', phone='"+phone+"', email='"+email+"', address='"+address+"')";
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
            this.name = rs.getString("f_name");
            this.surname = rs.getString("l_name");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
            this.role = rs.getInt("user_role");
            
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
    public void authenticateUser(String username, String password) throws Exception{
        String retrieveQuery =  "SELECT * FROM users WHERE username = "+ "'" + username + "'" + " AND passw ="+ "'" + getPasswordHash(password) + "'";
        ResultSet rs = Helper.retrieve(retrieveQuery);
        int id;
        if(rs.next()){
            address = rs.getString("address"); 
            this.username = rs.getString("username");
            this.password = rs.getString("passw");
            this.name = rs.getString("f_name");
            this.surname = rs.getString("l_name");
            this.phone = rs.getString("phone");
            this.email = rs.getString("email");
            this.role = rs.getInt("user_role");
            id = rs.getInt("id");
            
            //retrieveProducts(id);
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
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
            addProduct(rs.getInt("cpu_id"));
            addProduct(rs.getInt("graphicsCard_id"));
            addProduct(rs.getInt("memory_id"));
            addProduct(rs.getInt("hdd_id"));
            addProduct(rs.getInt("ssd_id"));
            addProduct(rs.getInt("keyboard_id"));
            addProduct(rs.getInt("monitor_id"));
            addProduct(rs.getInt("mouse_id"));
            addProduct(rs.getInt("operatingSystem_id"));
            addProduct(rs.getInt("opticDrive_id"));
            addProduct(rs.getInt("speaker_id"));
        }
        else{
            Exception NoSuchTuple = new Exception("Tuple with given id does not exists!");
            throw NoSuchTuple;
        }
    }
    
    //stores users products to database
    public void storeProducts(int id) throws Exception{
        String storeQuery = "INSERT INTO user_component (user_id, motherboard_id, cpu_id, graphicsCard_id, memory_id, hdd_id, ssd_id, keyboard_id, monitor_id, mouse_id, operatingSystem_id, opticDrive_id, speaker_id)" +
                "VALUES (" + id;
        
        for(int i = 0; i < productIDs.size(); i++)
            storeQuery += "," + productIDs.get(i);
        
        storeQuery += ")";
            
            Helper.insert(storeQuery);
            
    }
    
    //deletes users products from database
    public void deleteProducts(int id) throws Exception{
        String deleteQuery = "DELETE FROM user_component WHERE user_id = " + id;       
         Helper.delete(deleteQuery);
    }
    
    //retrieves all users from 
    public static ArrayList<User> retrieveAllUsers() throws Exception{
        String retrieveQuery = "SELECT * FROM users";
        
        ArrayList<User> toReturn = new ArrayList<User>();
        
        ResultSet rs = Helper.retrieve(retrieveQuery);
        
        while(rs.next()){
            User temp = new User();
            temp.setAddress(rs.getString("address")); 
            temp.setUsername(rs.getString("username"));
            temp.setName(rs.getString("f_name"));
            temp.setSurname(rs.getString("l_name"));
            temp.setPhone(rs.getString("phone"));
            temp.setEmail(rs.getString("email"));
            temp.setRole(rs.getInt("user_role"));
            temp.setUserID(rs.getInt("id"));
            
            toReturn.add(temp);
        }
        
        return toReturn;
    }
    
}