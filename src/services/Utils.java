package services;

public class Utils {
	
	public static int getRandomId() {
		int min = 100000;
		int max = 999999;
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

}
