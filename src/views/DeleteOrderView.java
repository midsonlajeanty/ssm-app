package views;

import core.View;
import services.Console;
import controllers.OrderController;

public class DeleteOrderView extends View {
	
	private String[] orders;
	
	public DeleteOrderView(String[] orders) {
		this.orders = orders;
	}

	@Override
	public void render() {

		Console.printHeader("Delete Order");
		
		Console.print("Select Order: ");
		int orderRef = Console.getChoice(this.orders);

		final View view = OrderController.delete(orderRef);

		view.render();

	}

}
