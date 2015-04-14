package USCorg;

import java.sql.Date;
//The Comment class contains basic information of a comment, all stored in String 
//with the exception of a Date Object. Storing the information in a String minimizes
//memory usage and a fetch operation from the database can be performed when necessary

public class Comment {
	private int commentID; //unique commentID from db
	private String text; //the main text that a comment contains
	private String user; //the authors name of the comment
	private Date timeStamp; //the time when the comment is created
	
	//constructor
	Comment(int id, String text, String org, int aID, String auth, Date time){
		commentID = id;
		this.text = text;
		this.user = auth;
		timeStamp = time;
	}
	//toString function for easy printing
	@Override
	public String toString(){
		String toBePrinted = "";
		toBePrinted = text;
		toBePrinted = toBePrinted + "\n" + user;
		toBePrinted = toBePrinted + "\n" + timeStamp;
		return toBePrinted;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUser() {
		return user;
	}
	public void setAuthor(String user) {
		this.user = user;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
}
