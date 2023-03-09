package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.Model;
import core.ModelManager;

public class Order extends Model<Order> {
	
	private int tankId;
	private int confirmBy;
	private double quantity;
	private double price;
	private double total;
	private OrderStatus status;
	private LocalDateTime makeAt;
	
	public static ModelManager<Order> objects = new ModelManager<Order>("Orders");

	public Order(int tankId, double quantity, double price) {
		this.tankId = tankId;
		this.quantity = quantity;
		this.status = OrderStatus.PENDING;
		this.price = price;
	}
	
	@Override
	public boolean save() {
		this.total = this.price * this.quantity;
		this.makeAt = LocalDateTime.now();
		return super.save();
	}

	public int getTankId() { return this.tankId; }
	public double getConfirmeBy() {return this.confirmBy; }
	public double getQuantity() { return this.quantity; }
	public double getPrice() { return this.price; }
	public LocalDateTime getMakeAt() { return this.makeAt; }
	public OrderStatus getStatus() { return this.status; }
	public double getTotal() {return this.total; }
	
	public void setStatus(OrderStatus status) { this.status = status; }
	public void setConfirmBy(int id) { this.confirmBy = id;}
	
	public String toString() {
		Tank t = Tank.objects.find(this.tankId);
		Station s = Station.objects.find(t.getStationId());
		
		User admin = null;
		if(this.confirmBy != 0) {
			admin = User.objects.find(this.confirmBy);
		}
		
		return String.format("ID: %d\nSATION: %s\nTANKTYPE: %s\nQUANTITY: %,.2f\nPRICE: %,.2f\nTOTAL: %,.2f\nDATE: %s\nCONFIRM BY: %s\n",
			this.getId(),
			s.getName(),
			t.print(),
			this.quantity,
			this.price,
			this.getTotal(),
			this.makeAt.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm")),
			admin != null ? admin.getUsername() : "UNCONFIRMED"
		);
	}
	
	
}
