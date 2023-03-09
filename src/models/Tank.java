package models;

import core.Model;
import core.ModelManager;

public class Tank extends Model<Tank> {
	
	private int stationId;
	private TankType type;
	private double capacity;
	private double availableQuantity;
	
	public static ModelManager<Tank> objects = new ModelManager<Tank>("Tanks");
	
	public Tank(int stationId, TankType type, double capacity) {
		this.stationId = stationId;
		this.type = type;
		this.capacity = capacity;
		this.availableQuantity = 0;
	}
	
	public int getStationId() { return stationId; }
	public TankType getType() { return type; }
	public double getCapacity() { return capacity; }
	public double getAvailableQuantity() { return availableQuantity; }
	public void setStationId(int stationId) { this.stationId = stationId; }
	public void setType(TankType type) { this.type = type; }
	public void setCapacity(double capacity) { this.capacity = capacity; }
	public void setAvailableQuantity(double availableQuantity) { this.availableQuantity = availableQuantity; }
	
	public double getUsage() {
		return (this.availableQuantity / this.capacity) * 100;
	}
	
	public String print() {
		return this.getType() + " (" + this.getCapacity() + " Gal)";
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d\nTYPE: %s\nCAPACITY: %,.2f Gal\nAVAILABLE QT: %,.2f Gal\nUSAGE: %,.2f", 
			this.getId(),
			this.type, 
			this.capacity, 
			this.availableQuantity, 
			this.getUsage()
		) + " %\n";
	}
	

}
