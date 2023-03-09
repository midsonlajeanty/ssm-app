package models;

import core.Model;
import core.ModelManager;

public class User extends Model<User> {
	
	private String username;
	private String password;
	private boolean isAdmin;
	
	public static ModelManager<User> objects = new ModelManager<User>("Users");

	public User(String username, String password) {
		this.username = username;
		this.password = password;	
	}

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public boolean isAdmin() { return isAdmin; }
	
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) {this.password = password;}
	public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	@Override
	public String toString() {
		return this.username + (this.isAdmin ? " (ADMIN)" : "");
	}
	
}
