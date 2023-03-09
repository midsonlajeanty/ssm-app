package controllers;

import models.User;
import models.Order;
import models.Session;

import core.View;

import views.HomeView;
import views.ConfirmValidationOrderView;
import views.ErrorView;

public class AuthController {
	
	public static View authenticate(String username, String password) {
		try {
			User user = User.objects.findBy("getUsername", username);
			
			if(user == null || !user.checkPassword(password)) {
				return new ErrorView("Authentication Failed, Invalid Credentials !!!");
			}
			
			Session session = new Session(user.getId());
			session.start();
			
			return new HomeView();
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorView("Error Ocurred !!!");
		}
	}
	
	public static View adminConfirmAuthenticate(String username, String password, Order order) {
		try {
			User user = User.objects.findBy("getUsername", username);
			
			if(user == null || !user.checkPassword(password)) {
				return new ErrorView("Authentication Failed, Invalid Credentials !!!");
			}
			
			if(user.isAdmin()) {
				return new ConfirmValidationOrderView(user, order);
			}
			
			return new ErrorView("Permission Denied, Only Admin can Confirm Order !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorView("Error Ocurred !!!");
		}
	}
	
	public static void logout() {
		Session session = Session.getActiveSession();
		session.close();
	}

}
