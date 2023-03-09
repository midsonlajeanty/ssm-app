package models;

public enum OrderStatus {
	
	PENDING("pending"),
	
	COMPLETE("validate"),
	
	CANCEL("cancel");
	
	private final String name;
	
	private OrderStatus(String name) { this.name = name; }

	public String getName() { return name;}
}
