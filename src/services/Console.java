package services;

import java.util.Scanner;

public class Console {
	
	private static Scanner scString = new Scanner(System.in);
	private static Scanner scNumber = new Scanner(System.in);
	
	
	public static int getChoice(String[] options) {
		Console.printArray(options);
		
		int option;
		do {
			option = Console.getInt("Your Choice: ");
			
			if(option > options.length || option < 1) {
				Console.print("Invalid Option, Retry !!!");
			}
			
		} while (option > options.length || option < 1);
		
		Console.endl();
		
		return option;
	}

	public static String getString(String message) {
		System.out.print(message);
		return scString.nextLine();
	}
	
	public static int getInt(String message) {
		System.out.print(message);
		return scNumber.nextInt();
	}
	
	public static double getDouble(String message) {
		System.out.print(message);
		return scNumber.nextDouble();
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void endl() {
		System.out.println("");
	}
	
	public static void printHeader(Object obj) {
		Console.endl();
		System.out.println(obj);
		System.out.println("***********");
		Console.endl();
	}

	public static void printArray(String[] options) {
		for(int i = 0; i < options.length; i++) {
			Console.print((i+1) + "- " + options[i]);
		}
		Console.endl();
	}

	public static void pause() {
		Console.endl();
		Console.print("Press Enter to Continue ...");
		scString.nextLine();
	}

}
