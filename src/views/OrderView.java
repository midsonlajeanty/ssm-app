package views;

import core.View;
import services.Console;
import controllers.OrderController;

public class OrderView extends View {

	@Override
	public void render() {
		String[] options = {
			"Save Order", 		// 1
			"List Order",		// 2
			"Delete Order",		// 3
			"Exit" 				// 4
		};

		Console.printHeader("MANAGE STATION ***");

		boolean run = true;

		while (run) {
			View view = null;

			int option = Console.getChoice(options);

			switch (option) {
				case 1:
					view = OrderController.getView("/save");
					break;
				case 2:
					view = OrderController.getView("/list");
					break;
				case 3:
					view = OrderController.getView("/delete");
					break;
				case 4:
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
