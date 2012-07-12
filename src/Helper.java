import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Helper {
	
	static Connection conn = null; 
	static String dbURL = "jdbc:postgresql://localhost:5432/computer_creator";
	static String user = "postgres";
	static String password = "12345";
        static Statement st;
    
    /*
	 * Veritabaniyla baglanti ac.
	 */
    public static Statement openConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection( dbURL, user , password );
		conn.setAutoCommit( true );
		//System.out.println("Connection opened");
		return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);		
	}
	
    /*
     * Veritabaniyla olan baglantiyi kapat.
     */
	public static void closeConnection() throws Exception {
        conn.close();
    }
	
	public static void insert(String query) throws Exception{
		st = openConnection();
		st.executeUpdate(query);
                closeConnection();
	}
        
        public static void update(String query) throws Exception{
		st = openConnection();
		st.executeUpdate(query);
                closeConnection();
	}
        
        public static ResultSet retrieve(String query) throws Exception{
            st = openConnection();
            ResultSet temp = st.executeQuery(query);
            closeConnection();
            
            return temp;
        }
	

}
