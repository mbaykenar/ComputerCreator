import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Helper {
	
	Connection conn = null; 
	String dbURL = "jdbc:postgresql://localhost:5432/computer_creator";
	String user = "postgres";
	String password = "12345";
	ResultSet rs;
    Statement st;
    
    /*
	 * Veritabaniyla baglanti ac.
	 */
    public Statement openConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection( dbURL, user , password );
		conn.setAutoCommit( true );
		//System.out.println("Connection opened");
		return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);		
	}
	
    /*
     * Veritabaniyla olan baglantiyi kapat.
     */
	public void closeConnection() throws Exception {
        conn.close();
    }
	
	private void insertComponent() throws Exception{
		String insertComponentQuery = "insert into component(model, vendor, price) values('asd','asd','TL123,0')";
		st = openConnection();
		st.executeUpdate(insertComponentQuery);
	}
	
	public static void main(String args[]) throws Exception{
		Helper h = new Helper();
		h.insertComponent();
	}

}
