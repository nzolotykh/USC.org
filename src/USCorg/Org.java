package USCorg;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//The Org class contains information about an organization object.
//Data is stored in String and int.  Users and their access level is stored
//in a hashmap. Announcements and comments are stored in two Vectors.

public class Org {
	private String name; //name of the organization
	private String des; //description of the organization
	private String meetingTimes; //weekly meeting times of the organization, in dayTime format, e.g. M3pm-5pm.  Possible days are: M,T,W,Th,F,Sa,Su
	private String contact; //contact of organization, can be in any format, e.g. Calvin Leung 3127092231, 3127092231 Calvin, etcetc.
	private int memberNo; //number of members, just to keep track of the size of the organization, ******************remember to increment when adding new user
	private int dues; //dues every semester
	private String audience;//UG (UnderGrad) or G (Grad) or B (Both)
	private Map <Integer, String> users = new HashMap<Integer, String>(); //a map storing the userID as key and access level as value
	private Vector <Announcement> announcements = new Vector<Announcement>();
	private Vector <Comment> comments = new Vector<Comment>();

	//constructor with all variables
	public Org(String n, String d, String mt, String c, int mn, int du, String a, Map<Integer, String>users, Vector<Announcement> announcements, Vector<Comment> comments){
		name = n;
		des = d;
		meetingTimes = mt;
		contact = c;
		memberNo = mn;
		dues = du;
		audience = a;
		this.users = users;
		this.announcements = announcements;
		this.comments = comments;
	}
	//toString function for easy printing
	@Override
	public String toString(){
		String print = "orgName: ";
		print = print + name + "\nDes: " + des + "\nMT: " + meetingTimes + "\ncontact: " + contact + "\nmemberNo: " + memberNo + "\ndues: " + dues + "\naudience: " + audience;
		print = print + "\nusers: " + users.toString();
		print = print + "\nusers: " + announcements.toString();
		print = print + "\nusers: " + comments.toString();
		return print;
	}
	
	//get set functions
	public String getName(){
		return name;
	}
	public String getDes(){
		return des;
	}
	public String getMT(){
		return meetingTimes;
	}
	public String getcontact(){
		return contact;
	}
	public int getMemberNo(){
		return memberNo;
	}
	public int getDues(){
		return dues;
	}
	public String getAudience(){
		return audience;
	}
	public void setName(String n){
		name = n;
	}
	public void setDes(String d){
		des = d;
	}
	public void setMT(String mt){
		meetingTimes = mt;
	}
	public void setContact(String c){
		contact = c;
	}
	public void setMemberNo(int m){
		memberNo = m;
	}
	public void setDues(int d){
		dues = d;
	}
	public void setAudience(String d){
		audience = d;
	}
	public Map <Integer, String> getUsers() {
		return users;
	}
	public void setUsers(Map <Integer, String> users) {
		this.users = users;
	}
	public Vector <Announcement> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(Vector <Announcement> announcements) {
		this.announcements = announcements;
	}
	public Vector <Comment> getComments() {
		return comments;
	}
	public void setComments(Vector <Comment> comments) {
		this.comments = comments;
	}
}
