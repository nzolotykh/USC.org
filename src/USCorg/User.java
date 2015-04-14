package USCorg;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class User {
	private int userID; //Unique userid from database
	private String studentID; //usc student id
	private String fname; //first name of the student
	private String lname; //last name of the student
	private String pw; //md5 hashed password
	private String major; //major of the student
	private int yearOf; //graduating year
	private String uscName; //usc username without @usc.edu
	//map which stores organizations and the access rights of a user
	//access rights are in Strings: Owner, Manager, Subscriber, 
	private Map<Org,String> organizations = new HashMap<Org,String>(); 
	private Vector<Announcement> announcements = new Vector<Announcement>(); //vector for announcements
	private Vector<Comment> comments = new Vector<Comment>();//vector for comments
	private boolean loggedIn; //boolean for login: true for logged in and false for guest
	
	//constructor with all variables in the same order as above
	User(int u, String s, String fn, String ln, String p, String m, int y, String us, Map<Org, String> org, Vector<Announcement> ann, Vector<Comment> com, boolean l){
		userID = u;
		studentID = s;
		fname = fn;
		lname = ln;
		pw = p;
		major = m;
		yearOf = y;
		uscName = us;
		organizations = org;
		announcements = ann;
		comments = com;
		loggedIn = l;
	}
	//toString function for easy printing
	@Override
	public String toString(){
		String toBePrinted = "";
		toBePrinted = "userID: "+userID;
		toBePrinted = toBePrinted + "\nstudentID: " + studentID;
		toBePrinted = toBePrinted + "\nfname: " + fname;
		toBePrinted = toBePrinted + "\nlname: " + lname;
		toBePrinted = toBePrinted + "\npw: " + pw;
		toBePrinted = toBePrinted + "\nmajor: " + major;
		toBePrinted = toBePrinted + "\nyearOf: " + yearOf;
		toBePrinted = toBePrinted + "\nuscName: " + uscName;
		toBePrinted = toBePrinted + "\nOrganizations: " + organizations.toString();
		toBePrinted = toBePrinted + "\nAnnouncements: " + announcements.toString();
		toBePrinted = toBePrinted + "\nComments: " + comments.toString();
				
		return toBePrinted;
		
	}
	//get set functions
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getFirstName() {
		return fname;
	}
	public void setLastName(String lname) {
		this.lname = lname;
	}
	public String getLastName() {
		return lname;
	}
	public void setFirstName(String fname) {
		this.fname = fname;
	}
	public String getPassword() {
		return pw;
	}
	public void setPassword(String pw) {
		this.pw = pw;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getYearOf() {
		return yearOf;
	}
	public void setYearOf(int yearOf) {
		this.yearOf = yearOf;
	}
	public String getUscName() {
		return uscName;
	}
	public void setUscName(String uscName) {
		this.uscName = uscName;
	}

	public Map<Org, String> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(Map<Org, String> organizations) {
		this.organizations = organizations;
	}
	public Vector<Announcement> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(Vector<Announcement> announcements) {
		this.announcements = announcements;
	}
	public Vector<Comment> getComments() {
		return comments;
	}
	public void setComments(Vector<Comment> comments) {
		this.comments = comments;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
