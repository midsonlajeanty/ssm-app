package app;

import views.LoginView;
import models.User;
import services.Console;

public class Application {

	public void bootstrap() {
		User admin = new User("admin", "123456");
		admin.setAdmin(true);
		admin.save();
		
		User user = new User("user", "123456");
		user.save();
	}

	public void execute() {

		boolean run = true;

		while (run) {
			Console.printHeader("WELCOME ***");

			String[] options = { "Login", "Exit" };

			int option = Console.getChoice(options);

			switch (option) {
				case 1:
					new LoginView().render();
					break;
				case 2:
					run = false;
					Console.printHeader("GOOD BYE ***");
					break;
			}

			if (run) {
				Console.pause();
			}
		}

	}
}
