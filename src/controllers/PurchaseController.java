package controllers;

import java.util.ArrayList;

import core.View;
import models.Purchase;
import models.Tank;
import views.ErrorView;
import views.SuccessView;
import views.ListView;
import views.SavePurchaseView;

public class PurchaseController {

	public static View getView(String route) {
		switch (route) {
			case "/save": {
				
				ArrayList<Tank> tanks = Tank.objects.all();
				
				String[] tkString = new String[tanks.size()];
			
				for(int i = 0; i < tanks.size(); i++) {
					tkString[i] = tanks.get(i).toString();
				}
				
				return new SavePurchaseView(tkString);
			}
			case "/list": {
				String title = "List Purchase";
						
				ArrayList<Purchase> purchases = Purchase.objects.all();
				
				return new ListView<Purchase>(purchases, title);
			}
		}

		return new ErrorView("Route Does not Exist ...");
	}

	public static View save(int tankRef, double qt) {
		Tank t = Tank.objects.all().get(tankRef -1);
		
		if(t.getAvailableQuantity() + qt > t.getCapacity()) {
			return new ErrorView("You don't have enough space to store that amount.");
		}
		
		Purchase purchase = new Purchase(t.getId(), qt);
		
		if (purchase.save()) {
			t.setAvailableQuantity(t.getAvailableQuantity() + qt);
			t.save();
			return new SuccessView("Purchase Saved Sucsessfully !");
		}
		
		return new ErrorView("Error Occured");
	}
}
