/**
 * 
 */
package services;

import java.util.ArrayList;

import models.*;


public class Database {

	private static Database instance = null;

	@SuppressWarnings("unused")
	private ArrayList<User> Users = new ArrayList<User>();
	
	@SuppressWarnings("unused")
	private ArrayList<Session> Sessions = new ArrayList<Session>();
	
	@SuppressWarnings("unused")
	private ArrayList<Station> Stations = new ArrayList<Station>();
	
	@SuppressWarnings("unused")
	private ArrayList<Tank> Tanks = new ArrayList<Tank>();
	
	@SuppressWarnings("unused")
	private ArrayList<Purchase> Purchases = new ArrayList<Purchase>();

	@SuppressWarnings("unused")
	private ArrayList<Order> Orders = new ArrayList<Order>();
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public Object getCollections(String name) throws Exception {
		return this.getClass().getDeclaredField(name).get(this);
	}
}
