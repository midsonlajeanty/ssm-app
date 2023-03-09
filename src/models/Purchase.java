package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.Model;
import core.ModelManager;

public class Purchase extends Model<Purchase>{
	
	private int tankId;
	private double quantity;
	private LocalDateTime makeAt;
	
	public static ModelManager<Purchase> objects = new ModelManager<Purchase>("Purchases");
	
	public Purchase(int tankId, double quantity) {
		this.tankId = tankId;
		this.quantity = quantity;
		this.makeAt = LocalDateTime.now();
	}
	
	public int getTankId() { return this.tankId; }
	public double getQuantity() { return this.quantity; }
	public LocalDateTime getMakeAt() { return this.makeAt;}
	
	
	@Override
	public String toString() {
		Tank t = Tank.objects.find(this.tankId);
		Station s = Station.objects.find(t.getStationId());
		
		return String.format("ID: %d\nSTATION NAME: %s\nTANK: %s\nQUANTITY: %,.2f\nDATE: %s\n",
			this.getId(),
			s.getName(),
			t.print(),
			this.quantity,
			this.makeAt.format(
				DateTimeFormatter.ofPattern("d MMM uuuu HH:mm")
			)
		);
	}

}
