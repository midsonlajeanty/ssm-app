package models;

import java.util.ArrayList;
import java.util.Iterator;

import core.Model;
import core.ModelManager;

public class Station extends Model<Station> {
	
	private String name;
	
	public static ModelManager<Station> objects = new ModelManager<Station>("Stations");
	
	public Station(String name) {
		this.name = name;
	}

	public String getName() { return name;}

	public void setName(String name) { this.name = name; }
	
	public ArrayList<Tank> getTanks(){
		ArrayList<Tank> tanks = new ArrayList<Tank>();
		
		for(Tank t : Tank.objects.all()) {
			if(t.getStationId() == this.getId()) {
				tanks.add(t);
			}
		}
		return tanks;
	}
	
	@Override
	public String toString() {
		String text = "(ID: " + this.getId() + ") " + this.name;
		
		Iterator<Tank> iterator = this.getTanks().iterator();
		
		if(this.getTanks().size() > 0) {
			text += "\n- Tank List ***\n";
		}
		
		while (iterator.hasNext()) {
			Tank t = iterator.next();
			text += t.toString() + "\n";
		}
		
		if(this.getTanks().size() > 0) {
			text += "- End Tank List ***\n";
		}
		
		return text;
	}
}
