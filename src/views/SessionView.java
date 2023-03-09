package views;

import controllers.SessionController;
import core.View;
import services.Console;

public class SessionView extends View{

	@Override
	public void render() {
		
		String[] options = {
			"List Session", 		// 1
			"List Active Session",	// 2
			"Exit"					// 3
		};
		
		Console.printHeader("MANAGE SESSION ***");
		
		boolean run = true;
		
		while(run) {
			View view = null;
			
			int option = Console.getChoice(options);
				
			switch (option) {
				case 1:
					view = SessionController.getView("/all");
					break;
				case 2:
					view = SessionController.getView("/active");
					break;
				case 3:
					run = false;
					break;
			}
			
			if(run) {
				view.render();
				Console.pause();
			}
				
		}
		
	}
}
