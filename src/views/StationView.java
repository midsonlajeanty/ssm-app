package views;

import core.View;
import services.Console;
import controllers.StationController;

public class StationView extends View {

	@Override
	public void render() {
		String[] options = {
			"Add Station", 			// 1
			"List Station", 		// 2
			"Less reserve Station", // 3
			"More reserve Station", // 4
			"Exit" 					// 5
		};

		Console.printHeader("MANAGE STATION ***");

		boolean run = true;

		while (run) {
			View view = null;

			int option = Console.getChoice(options);

			switch (option) {
				case 1:
					view = StationController.getView("/add");
					break;
				case 2:
					view = StationController.getView("/list");
					break;
				case 3:
					view = StationController.getView("/less-reserve");
					break;
				case 4:
					view = StationController.getView("/more-reserve");
					break;
				case 5:
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
