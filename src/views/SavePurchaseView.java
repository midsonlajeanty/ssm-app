package views;

import core.View;
import services.Console;
import controllers.PurchaseController;

public class SavePurchaseView extends View {
	
	private String[] tanks;
	
	public SavePurchaseView(String[] tanks) {
		this.tanks = tanks;
	}

	@Override
	public void render() {

		Console.printHeader("Save Purchase ---");
		
		Console.print("Select Tank Station: ");
		int tankRef = Console.getChoice(this.tanks);
		
		double qt = Console.getDouble("Enter the quantity buying: ");

		final View view = PurchaseController.save(tankRef, qt);

		view.render();

	}

}
