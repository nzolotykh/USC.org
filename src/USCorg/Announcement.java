package USCorg;

import java.sql.Date;
//The Announcement class contains basic information of a comment, all stored in String 
//with the exception of a Date Object. Storing the information in a String minimizes
//memory usage and a fetch operation from the database can be performed when necessary
import java.util.Vector;

public class Announcement {
	private int announcementID; //unique announcementID from db
	private String org; //the organization name that the announcement belongs to
	private String user; //the authors name of the announcement
	private String text; //the main text that an announcement contains
	private String title; //the title of the announcement
	private Date date; // the date when the announcement is posted
	private Vector<Comment> comments = new Vector<Comment> ();
	
	//constructor
	Announcement(int announcementID, String org, String user, String text, String title, Date date){
		this.org = org;
		this.user = user;
		this.text = text;
		this.title = title;
		this.date = date;
	}
	
	//get set functions
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getAnnouncementID() {
		return announcementID;
	}

	public void setAnnouncementID(int announcementID) {
		this.announcementID = announcementID;
	}

	public Vector<Comment> getComments() {
		return comments;
	}

	public void setComments(Vector<Comment> comments) {
		this.comments = comments;
	}
	
}
