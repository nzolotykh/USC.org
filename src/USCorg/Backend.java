package USCorg;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//The Backend class contains functions that the GUI, i.e. MainFrame, could utilize.
//This class is responsible for all the data manipulation, authentication needed
//from GUI function calls.  The Backend calls functions from the Database class
//to fetch, update, delete information from the mysql database.

public class Backend {
	private static User currentUser; //current User object
	static {
		currentUser = makeGuestUser();
	}
	private static Org currentOrg;
	static {
		//currentOrg = 
	}
	
	private static Announcement currentAnnouncement;
	static {
		//currentAnnouncement = 
	}
	
	//returns true if login is successful, 
	//also sets currentUser to the logged in user if successful
	//else returns false
	public static boolean login(String username, String password){
		//TODO change the password verification once implemented hashing
		
		currentUser = Database.fetchUserwithUsername(username);

		if (currentUser == null) {
			//user does not exist
			return false;
		} else {
			//user exists, must do a password check
			boolean passwordMatches = false;
			try {
				passwordMatches = PasswordHash.validatePassword(password.toCharArray(), currentUser.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
			if (!passwordMatches) {
				//password does not match
				currentUser = makeGuestUser();
				return false;
			} else {
				//password matches & user exists
				//login successful!
				return true;
			}
		}
	}
	
	//make currentUser into a guest user with dummy variables, 
	//called on startup/ logout 
	public static User makeGuestUser(){
		return new User(0, "0000000000", "Tommy", "Trojan", "Guest", "pw", 0000, "trojan", new HashMap<Org,String>(), new Vector<Announcement>(), new Vector<Comment>(), true);
	}
	
	//PBKDF2 password hashing (utilizes SHA1)
	public String hashPassword (String password){
		String hash = "";
		try {
			hash = PasswordHash.createHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	public static boolean register(String firstName, String lastName, String email, String uscID, String password, String major, int yearOf){
		/*
		 * the registration function: tied to the registerButton in GUI
		 * returns true if the registration was successful
		 * returns false if one of the text fields was entered incorrectly
		 */
				
		if (!firstName.matches("[A-Za-z]+") || !lastName.matches("[A-Za-z]+")) {
			//first name and last name must consist of letters only
			return false;
		}
		if (!email.matches("[\\.A-Za-z0-9_]+@usc.edu")) {
			//email must be of the email format + @usc.edu is required
			return false;
		}
		if (!uscID.matches("[0-9]{10}")) {
			//USCID must be exactly 10 digits long
			return false;
		}
		if (password.length() < 8) {
			//password can be any characters, but must have at least 8 characters
			return false;
		}
		
		String username = email.substring(0, email.length()-8); //converting email to username
		if(!Database.usernameIsValid(username)) {
			//username already exists
			return false;
		}
		
		if(!Database.idIsValid(uscID)) {
			//ID already exists
			return false;
		}
		
		//hashing the password to send it to the database
		String passwordHash = "";
		try {
			passwordHash = PasswordHash.createHash(password);
		} catch (NoSuchAlgorithmException e) {e.printStackTrace();}
		catch (InvalidKeySpecException e) {e.printStackTrace();}

		Database.insertUser(uscID, firstName, lastName, passwordHash, major, yearOf, username);
		currentUser = Database.fetchUserwithUsername(username);
		return true;
	}
	
	public static boolean newComment(String text, String org, int aID, String auth) {
		if (text.length() > 160) {
			return false;
		}
		//Database.addComment(
		return true;
	}
	
	public static boolean newOrganization(String orgName, String d, String mt, String c, int mn, int du, String a, Map<Integer, String>users, Vector<Announcement> announcements, Vector<Comment> comments) {
		if (!Database.orgNameIsValid(orgName)) {
			return false;
		}
		return true;
	}
	
	public static boolean newEvent() {
		
		return true;
	}
	
	public static boolean newAnnouncement() {

		return true;
	}
	
	public static boolean newCalendar() {
		
		return true;
	}
	
	public static boolean changeUserInfo(String uscID, String firstName, String lastName, String nickname, String password, String major, int yearOf, String uscName) {
		/* this function will be used to change the user account info
		 * if no changes are necessary for a specific parameter, simply pass in null as that parameter
		 * For example, if the user wants to change only the major, we would use this function and
		 * pass in everything as null, except the major parameter.
		 * If any changes were made, returns true. Otherwise, returns false.
		 */
		
		boolean changeMade = false;
		
		//checking if any of the parameters were entered
		if (uscID != null) {
			currentUser.setStudentID(uscID);
			changeMade = true;
		}
		if (firstName != null) {
			currentUser.setFirstName(firstName);
			changeMade = true;
		}
		if (lastName != null) {
			currentUser.setLastName(lastName);
			changeMade = true;
		}
		if (password != null) {
			currentUser.setPassword(password);
			changeMade = true;
		}
		if (major != null) {
			currentUser.setMajor(major);
			changeMade = true;
		}
		if (yearOf != -1) {
			currentUser.setYearOf(yearOf);
			changeMade = true;
		}
		if (uscName != null) {
			currentUser.setUscName(uscName);
			changeMade = true;
		}
		//end of the check
		
		if (changeMade) {
			return true;
		} else {
			return false;
		}
	}
	
	public static ArrayList<String> getUserOrganizationsNames(User user) {
		/* 
		 * this function returns an ArrayList<String> with the names
		 * of all organizations that the user is in.
		 * This will be used in UI for the sidebar listing current user's
		 * orgs, or for looking at other people's profiles.
		 * Returns an empty ArrayList<String> if the user has no organizations,
		 * otherwise just returns the list with the org names.
		 */
		if (user.getOrganizations().isEmpty()) {
			//user has no organizations assigned
			return new ArrayList<String>();
		} else {
			//fetching the names of the organizations
			ArrayList<String> orgsList = new ArrayList<String>();
			Map<Org,String> userOrgsMap = user.getOrganizations();
			for (Map.Entry<Org, String> entry : userOrgsMap.entrySet()) {
				orgsList.add(entry.getKey().getName());
			}
			return orgsList;
		}
	}
	
	//get set functions
	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User newCurrentUser) {
		currentUser = newCurrentUser;
	}
	
	public static void main(String [] args) {
		/* 
		 * THIS WILL BE DELETED ... USED JUST FOR TESTING
		 */
		
		/*System.out.println(register("First", "last", "email@usc.edu", "8629729642", "password"));
		User user = new User(0, "8629729642", "nikita", "zolotykh", "niki", "password", "CSBA", 2016, "uscname??", null, null, null, false);
		
		Org judoClub = new Org("Judo Club", "des?", "yay meetings", null, 0, 0, null, null, null, null);
		Org soccerClub =  new Org("Soccer Club", null, null, null, 0, 0, null, null, null, null);
		Map<Org, String> organizations = new HashMap<Org, String>();
		organizations.put(judoClub, "Member");
		organizations.put(soccerClub, "PRESIDENT");
		
		user.setOrganizations(organizations);
		
		ArrayList<String> userOrgsList = getUserOrganizationsNames(user);
		for (int i = 0; i < userOrgsList.size(); i++) {
			System.out.println(userOrgsList.get(i));
		}*/
		
	}

	
}



/* Nikita's personal notes
 * 
 * User constructor: should the ID be automatically generated through the database?
 * 
 */
