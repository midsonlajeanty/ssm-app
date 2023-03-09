package views;

import controllers.AuthController;
import core.View;
import services.Console;

public class HomeView extends View {

	@Override
	public void render() {

		String[] options = {
			"Manage Order", 		// 1
			"Manage Station", 		// 2
			"Manage Purchase", 		// 3
			"Manage Sessions", 		// 5
			"Logout" 				// 6
		};

		Console.printHeader("WELCOME ***");

		boolean run = true;

		while (run) {

			int option = Console.getChoice(options);

			switch (option) {
				case 1:
					new OrderView().render();
					break;
				case 2:
					new StationView().render();
					break;
				case 3:
					new PurchaseView().render();
					break;
				case 4:
					new SessionView().render();
					break;
				case 5:
					AuthController.logout();
					run = false;
					break;
			}

			if (run) {
				Console.pause();
			}
		}
	}
}
