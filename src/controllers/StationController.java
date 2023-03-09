package controllers;

import java.util.ArrayList;

import core.View;

import models.Station;
import models.Tank;
import models.TankType;
import views.AddStationView;
import views.ErrorView;
import views.SuccessView;
import views.ListView;

public class StationController {

	public static View getView(String route) {
		switch (route) {
			case "/add": {
				return new AddStationView();
			}
			case "/list": {
				String title = "List Station";
						
				ArrayList<Station> stations = Station.objects.all();
				
				return new ListView<Station>(stations, title);
			}
			case "/less-reserve": {
				String title = "Less Reserve Station";
						
				ArrayList<Station> stations = Station.objects.all();
				ArrayList<Station> maxStations = new ArrayList<Station>();
				
				Station min1 = stations.stream().min(
					(st1, st2) ->  Double.compare(
						st1.getTanks().get(0).getAvailableQuantity(), 
						st1.getTanks().get(0).getAvailableQuantity()
					)
				).get();
				maxStations.add(min1);
				
				Station min2 = stations.stream().min(
					(st1, st2) ->  Double.compare(
						st1.getTanks().get(1).getAvailableQuantity(), 
						st1.getTanks().get(1).getAvailableQuantity()
					)
				).get();
				maxStations.add(min2);
				
				return new ListView<Station>(maxStations, title);
			}
			case "/more-reserve": {
				String title = "More Reserve Station";
						
				ArrayList<Station> stations = Station.objects.all();
				ArrayList<Station> maxStations = new ArrayList<Station>();
				
				Station max1 = stations.stream().max(
					(st1, st2) ->  Double.compare(
						st1.getTanks().get(0).getAvailableQuantity(), 
						st1.getTanks().get(0).getAvailableQuantity()
					)
				).get();
				
				maxStations.add(max1);
				
				Station max2 = stations.stream().max(
					(st1, st2) ->  Double.compare(
						st1.getTanks().get(1).getAvailableQuantity(), 
						st1.getTanks().get(1).getAvailableQuantity()
					)
				).get();
				maxStations.add(max2);
				
				return new ListView<Station>(maxStations, title);
			}
		}

		return new ErrorView("Route Does not Exist ...");
	}

	public static View add(String name, double gasCap, double dieCap) {
		Station station = new Station(name);
		
		Tank gas = new Tank(station.getId(), TankType.GASOLINE, gasCap);
		gas.save();
		
		Tank die = new Tank(station.getId(), TankType.DIESEL, dieCap);
		die.save();
		
		if (station.save()) {
			return new SuccessView("Station added Sucsessfully !");
		} 
		
		return new ErrorView("Error Occured");
	}
}
