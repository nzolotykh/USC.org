package USCorg;

public class Event {
	private int eventID;
	private int date;
	private String eventName;
	private Org org;
	private String location;
	private String text;
	
	//Constructor
	Event(int id, String text, Org org, int date, String location, String name) {
		eventID = id;
		this.date = date;
		eventName = name;
		this.org = org;
		this.location = location;
		this.text = text;
	}
	
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int id) {
		eventID = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//public String 

}
