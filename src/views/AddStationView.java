package views;

import controllers.StationController;
import core.View;
import services.Console;

public class AddStationView extends View {

	@Override
	public void render() {

		Console.printHeader("Add Station ---");

		String name = Console.getString("Enter station Name: ");
		
		double dieselCapacity = Console.getDouble("Enter Diesel Tank Capacity: ");
		
		double gasolineCapacity = Console.getDouble("Enter Gasoline Tank Capacity: ");

		final View view = StationController.add(name, dieselCapacity, gasolineCapacity);

		view.render();

	}

}
