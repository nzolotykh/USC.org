package USCorg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Pair<T1, T2>{
	T1 first;
	T2 second;
	
	Pair(T1 a, T2 b){
		first = a;
		second = b;
	}
}

public class Database {
	
	private static Connection conn; //JDBC connection object
	private static Statement st; //JDBC statement
	private static PreparedStatement ps; //JDBC prepared statement 
	private static ResultSet rs; //result set 
	//address,port,database name for remote connection
	private static final String url = "jdbc:mysql://107.170.220.236:3306/UserDB"; 
	//database username 
    private static final String user = "yuikwanl";
    //password associated with the username
    private static final String pass = "USC.org";
    
    //initializer for JDBC variables and connection to db 
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			st = conn.createStatement();
		} catch (SQLException sqle) {
			System.out.println ("SQLException: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException: " + cnfe.getMessage());
		}
	}
	
	//constructor
	Database(){
		
	}
	
	//User functions
	//returns a username string when provided with the unique userid
	public static String fetchUsername(int id){
		String lname = "";
		String fname = "";
		String username = "";
		try {
			
			ps = conn.prepareStatement("SELECT * FROM users WHERE userID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			fname = rs.getString("fname");
			lname = rs.getString("lname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username = fname + " " + lname;
		username = fname + " " + lname;
		return username;
	}
	//returns a studentID string when provided with the unique userid
	public static String fetchStudentID(int id){
		String studentid = "";
		try {
			ps = conn.prepareStatement("SELECT * FROM users WHERE userID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			studentid = rs.getString("studentID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentid;
	}
	//returns a password string when provided with the unique userid
	public static String fetchpw(int id){
		String pw = "";
		try {
			
			ps = conn.prepareStatement("SELECT * FROM users WHERE userID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			pw = rs.getString("pw");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pw;
	}
	//returns a major string when provided with the unique userid
	public static String fetchMajor(int id){
		String major = "";
		try {
			
			ps = conn.prepareStatement("SELECT * FROM users WHERE userID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			major = rs.getString("major");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return major;
	}
	//returns a user object when provided with a username string
	public static User fetchUserwithUsername(String username){
		int userID = 0;
		String studentID = "";
		String fname = "";
		String lname = "";
		String pw = ""; 
		String major = "";
		int yearOf = 0;
		String uscName = "";
		Map<Org,String> organizations = new HashMap<Org,String>();
		Vector<Announcement> announcements = new Vector<Announcement>();
		Vector<Comment> comments = new Vector<Comment>();
		boolean userExists = false;
		try {
			
			ps = conn.prepareStatement("SELECT * FROM users WHERE uscName=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()){
				userExists = true;
				userID = rs.getInt("userID");
				studentID = rs.getString("studentID");
				fname = rs.getString("fname");
				lname = rs.getString("lname");
				pw = rs.getString("pw"); 
				major = rs.getString("major");
				yearOf = rs.getInt("yearOf");
				uscName = rs.getString("uscName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userExists){
			return new User(userID, studentID, fname, lname, pw, major, yearOf, uscName, organizations, announcements, comments, true);
		}else{
			return null;
		}
		
	}
	//
	public static Vector <User> fetchUser(int number, String string, String instruction){
		User user;
		
		
		Vector <User> users = new Vector <User> ();
		
		return users;
	}
	
	//returns true if username is not used
	public static boolean usernameIsValid(String username){
		try {
			ps = conn.prepareStatement("SELECT * FROM users WHERE uscName=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	//returns true if uscID is not in database
	public static boolean idIsValid(String uscID){
				try {
					ps = conn.prepareStatement("SELECT * FROM users WHERE studentID=?");
					ps.setString(1, uscID);
					rs = ps.executeQuery();
					while(rs.next()){
						return false;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
		}
	//returns true if user is successfully added
	public static boolean insertUser(String studentID, String fname, String lname, String pw, String major, int yearOf, String uscName){
		try {
			ps = conn.prepareStatement("INSERT INTO users (studentID, fname, lname, pw, major, yearOf, uscName) VALUES (" + studentID + ", \'" + fname + "\', \'" + lname + "\', \'" + pw + "\', \'" + major + "\'," + yearOf + ", \'" + uscName + "\');" );
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//returns true if user is successfully updated
	public static boolean updateUser(String studentID, String fname, String lname, String pw, String major, int yearOf, String uscName){
		try {
			ps = conn.prepareStatement("UPDATE users SET studentID = \'" + studentID +"\', fname=\'" + fname +"\', lname=\'" + lname+"\', pw=\'" + pw+"\', major=\'" + major+"\', yearOf=\'" + yearOf+"\', uscName=\'" + uscName + "\' WHERE uscName=?;");
			ps.setString(1, uscName);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//Org Functions
	//Search and returns a vector of <orgName, description> with a keyword
 	public static Vector< Pair<String, String> > searchOrgs (String keyword ){
		String name = "";
		String des = "";
		Pair<String,String> pair = new Pair<String,String> ("","");
		Vector <Pair<String,String> > orgs = new Vector< Pair<String,String> >();
		try {
			ps = conn.prepareStatement("SELECT * FROM org WHERE orgName LIKE?");
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			while (rs.next()){
				name = rs.getString("orgName");
				des = rs.getString("des");
				pair = new Pair<String,String> (name, des);
				orgs.add(pair);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orgs;
	}
	
 
	//returns a organization object when provided with the unique orgid
 	public static Org fetchOrgwithOrgname(String orgName){
		String name = "";
		String des = "";
		String meetingTimes = "";
		String contact = "";
		int memberNo = 0;
		int dues = 0;
		String audience = "";
		Map<Integer, String>users = new HashMap<Integer, String>();
		Vector<Announcement> announcements = new Vector<Announcement>();
		Vector<Comment> comments = new Vector<Comment>();
		try {
			
			ps = conn.prepareStatement("SELECT * FROM org WHERE orgName=?");
			ps.setString(1, orgName);
			rs = ps.executeQuery();
			rs.next();
			name = rs.getString("orgName");
			des = rs.getString("des");
			meetingTimes = rs.getString("meetingTimes");
			contact = rs.getString("contact");
			memberNo = rs.getInt("memberNo");
			dues = rs.getInt("dues");
			audience = rs.getString("audience");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Org org = new Org(name, des, meetingTimes, contact, memberNo, dues, audience, users, announcements, comments);
		return org;
	}
	//returns an orgName string when provided with the unique orgid
	public static String fetchOrgName(int id){
		String name = "";
		try {
			ps = conn.prepareStatement("SELECT * FROM org WHERE orgID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			name = rs.getString("orgName");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
 	
	//returns true if orgName is not used
	public static boolean orgNameIsValid(String orgName){
			try {
				ps = conn.prepareStatement("SELECT * FROM org WHERE orgName=?");
				ps.setString(1, orgName);
				rs = ps.executeQuery();
				while(rs.next()){
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	
	//announcements function
	public static boolean insertAnnouncement(int orgID, int userID, String text){
		try {
			ps = conn.prepareStatement("INSERT INTO annoucements(date_posted, userID, orgID, an_text) VALUES (NOW(), \'" + userID + "\', + \'" + orgID + "\', \'" + text + "\';");
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//comments function
	public static boolean insertComment(int announcementID, int userID, String text){
		try {
			ps = conn.prepareStatement("INSERT INTO comments(date_posted, userID, announcementID, com_text) VALUES (NOW(), \'" + userID + "\', + \'" + announcementID + "\', \'" + text + "\';");
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
 	public static void main(String [] args){
 		updateUser("1230802932", "nikita", "nikita", "500:fb9311a62b75:165b1fa89b92", "CS", 2016, "nikita");
		System.out.println(fetchUserwithUsername("nikita"));
		System.out.println(fetchOrgwithOrgname("ACM"));
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/UserDB?user=root");
			Statement st = conn.createStatement();
			String name = "Calvin";
			String laname = "Leung";
			//ResultSet rs = st.executeQuery("SELECT * from Student where fname='" + name + "'");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE fname=? OR lname =?");
			ps.setString(1, name); // set first variable in prepared statement
			ps.setString(2, laname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String studentID = rs.getString("studentID");
				System.out.println ("fname = " + fname);
				System.out.println ("lname = " + lname);
				System.out.println ("studentID = " + studentID);
			}
			name = "ACM";
			laname = "Jeffrey Miller";
			//ResultSet rs = st.executeQuery("SELECT * from Student where fname='" + name + "'");
			ps = conn.prepareStatement("SELECT * FROM org WHERE orgName=? OR contact =?");
			ps.setString(1, name); // set first variable in prepared statement
			ps.setString(2, laname);
			rs = ps.executeQuery();
			while (rs.next()) {
				String fname = rs.getString("orgName");
				String lname = rs.getString("contact");
				String des = rs.getString("des");
				System.out.println ("fname = " + fname);
				System.out.println ("lname = " + lname);
				System.out.println ("description = " + des);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println ("SQLException: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException: " + cnfe.getMessage());
		}*/
	}
}
