package models;

import core.Model;
import core.ModelManager;

import java.util.Iterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Session extends Model<Session> {
	
	private LocalDateTime start;
	private LocalDateTime end;
	private int userId;
	
	public static ModelManager<Session> objects = new ModelManager<Session>("Sessions");
	
	public Session(int userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getStart() { return start; }

	public void setStart(LocalDateTime start) { this.start = start; }

	public void start() {
		this.start = LocalDateTime.now();
		this.end = null;
		this.save();
	}
	
	public boolean isActive() {
		return this.end == null;
	}
	
	public void close() {
		this.end = LocalDateTime.now();
	}
	
	public static Session getActiveSession() {
		Iterator<Session> iterator = Session.objects.all().iterator();
	
		while(iterator.hasNext()) {
			Session s = iterator.next();
			if(s.isActive()) {
				return s;
			}
		}
		
		return null;
	}
	
	public static User getAuthenticateUser() {
		Session session = Session.getActiveSession();
		
		if(session != null) {
			return User.objects.find(session.userId);
		}
		
		return null;
	}
	
	public String toString() {
		User user = User.objects.find(this.userId);
		
		return String.format("ID: %d\nUSER ID: %d\nUSERNAME: %s\nSTART TIME: %s\nEND TIME: %s\n",
			this.getId(),
			this.userId,
			user.getUsername(),
			this.start.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm")), 
			this.isActive() ? "ACTIVE": this.end.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm"))
		);
	}

}
