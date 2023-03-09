package views;

import core.View;

import models.Order;
import models.User;

import services.Console;

import controllers.OrderController;

public class ConfirmValidationOrderView extends View{
	
	private User admin;
	private Order order;
	
	public ConfirmValidationOrderView(User admin, Order order) {
		this.admin = admin;
		this.order = order;
	}
	
	@Override
	public void render() {
		
		Console.printHeader("Confirm Validation Order");
		
		Console.print(order.toString());
		
		Console.print(this.admin + ", Do you want validate order ?");
		
		String[] options = { "Oui", "Non"};
		
		int option = Console.getChoice(options);
		
		View view = OrderController.validateOrder(option, order, this.admin);
		
		view.render();
	}

}
