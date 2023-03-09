package views;

import controllers.AuthController;
import core.View;
import models.Order;
import services.Console;

public class ValidateOrderView extends View{
	
	private Order order;
	
	public ValidateOrderView(Order order) {
		this.order = order;
	}
	
	@Override
	public void render() {
		
		Console.printHeader("ADMIN CONFIRM ***");
		
		String username = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		
		View view = AuthController.adminConfirmAuthenticate(username, password, order);
		
		view.render();
	}

}
