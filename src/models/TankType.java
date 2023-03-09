package models;

public enum TankType {
	
	GASOLINE("Gasoline", 250),
	
	DIESEL("Diesel", 353);
	
	private final String type;
	private final double price;
	
	private TankType(String type, double price) { 
		this.type = type; 
		this.price = price;
	}

	public String getType() { return this.type; }
	public double getPrice() { return this.price; }
}
