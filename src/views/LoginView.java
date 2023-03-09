package views;

import controllers.AuthController;
import core.View;
import services.Console;

public class LoginView extends View{
	
	@Override
	public void render() {
		
		Console.printHeader("LOGIN");
		
		String username = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		
		View view = AuthController.authenticate(username, password);
		
		view.render();
	}

}
