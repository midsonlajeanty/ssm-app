package controllers;

import java.util.ArrayList;

import core.View;
import models.Session;
import views.ErrorView;
import views.ListView;

public class SessionController {
	public static View getView(String route) {
		ArrayList<Session> sessions = Session.objects.all();;
		
		switch(route) {
			case "/all":{
				String title = "List Session";
				
				return new ListView<Session>(sessions, title);
			}
			case "/active":{
				String title = "List Session";
				
				ArrayList<Session> activeSessions = new ArrayList<Session>();
				
				for(Session s : sessions) {
					if(s.isActive()) {
						activeSessions.add(s);
					}
				}
				return new ListView<Session>(activeSessions, title);
			}
		}
		
		return new ErrorView("Route Does not Exist ...");
	}
}
