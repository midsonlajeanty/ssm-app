package controllers;

import java.util.ArrayList;

import core.View;

import models.Order;
import models.OrderStatus;
import models.Session;
import models.Tank;
import models.User;
import views.DeleteOrderView;
import views.ErrorView;
import views.SuccessView;
import views.ListView;

import views.SaveOrderView;
import views.ValidateOrderView;

public class OrderController {

	public static View getView(String route) {
		switch (route) {
			case "/save": {
				
				ArrayList<Tank> tanks = Tank.objects.all();
				
				String[] tkString = new String[tanks.size()];
			
				for(int i = 0; i < tanks.size(); i++) {
					tkString[i] = tanks.get(i).toString();
				}
				
				return new SaveOrderView(tkString);
			}
			case "/list": {
				String title = "List Order";
						
				ArrayList<Order> orders = Order.objects.all();
				
				return new ListView<Order>(orders, title);
			}
			case "/delete": {
						
				ArrayList<Order> orders = Order.objects.all();
				
				String[] orString = new String[orders.size()];
			
				for(int i = 0; i < orders.size(); i++) {
					orString[i] = orders.get(i).toString();
				}
				
				return new DeleteOrderView(orString);
			}
		}

		return new ErrorView("Route Does not Exist ...");
	}

	public static View save(int tankRef, double qt) {
		Tank t = Tank.objects.all().get(tankRef -1);
		
		if(t.getAvailableQuantity() < qt) {
			return new ErrorView("You don't have enough gas available to sell.");
		}
		
		Order order = new Order(t.getId(), qt, t.getType().getPrice());
		
		if (order.save()) {
			
			User user = Session.getAuthenticateUser();
			
			if(user.isAdmin()) {
				return OrderController.validateOrder(1, order, user);
			}
			
			return new ValidateOrderView(order);
		}
		
		return new ErrorView("Error Occured");
	}
	
	public static View delete(int orderRef) {
		Order o = Order.objects.all().get(orderRef -1);
		
		User user = Session.getAuthenticateUser();
		
		if(!user.isAdmin()) {
			return new ErrorView("You don't have permission to delete Order.");
		}
		
		if (o.delete()) {
			return new SuccessView("Order deleted Successfully !!!");
		}
		
		return new ErrorView("Error Occured");
	}
	
	public static View validateOrder(int res, Order order, User admin) {
		
		String message = "";
		if(res == 1) {
			Tank tank = Tank.objects.find(order.getTankId());
			
			tank.setAvailableQuantity(tank.getAvailableQuantity() - order.getQuantity());
			tank.save();
			
			order.setStatus(OrderStatus.COMPLETE);
			message = "Order validate Successfully !!!";
		}else {
			order.setStatus(OrderStatus.CANCEL);
			message = "Order cancel Successfully !!!";
		}
		
		order.setConfirmBy(admin.getId());
		
		if (order.save()) {
			return new SuccessView(message);
		} 
		
		return new ErrorView("Error Occured !!!");
	}
}
