package views;

import core.View;
import services.Console;
import controllers.PurchaseController;

public class PurchaseView extends View {

	@Override
	public void render() {
		String[] options = {
			"Save Purchase", 		// 1
			"List Purchase", 		// 3
			"Exit" 					// 6
		};

		Console.printHeader("MANAGE STATION ***");

		boolean run = true;

		while (run) {
			View view = null;

			int option = Console.getChoice(options);

			switch (option) {
				case 1:
					view = PurchaseController.getView("/save");
					break;
				case 2:
					view = PurchaseController.getView("/list");
					break;
				case 3:
					run = false;
					break;
			}

			if (run) {
				view.render();
				Console.pause();
			}

		}

	}

}
