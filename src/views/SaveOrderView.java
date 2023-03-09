package views;

import core.View;
import services.Console;
import controllers.OrderController;

public class SaveOrderView extends View {
	
	private String[] tanks;
	
	public SaveOrderView(String[] tanks) {
		this.tanks = tanks;
	}

	@Override
	public void render() {

		Console.printHeader("Save Order");
		
		Console.print("Select Tank Station: ");
		int tankRef = Console.getChoice(this.tanks);
		
		double qt = Console.getDouble("Enter the quantity buying: ");

		final View view = OrderController.save(tankRef, qt);

		view.render();

	}

}
