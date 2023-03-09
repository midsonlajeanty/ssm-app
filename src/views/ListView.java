package views;

import java.util.ArrayList;
import java.util.Iterator;

import core.View;
import services.Console;

public class ListView<T> extends View{
	
	private ArrayList<T> data;
	private String title;

	public ListView(ArrayList<T> data, String title) {
		this.data = data;
		this.title = title;
	}

	@Override
	public void render() {
		
		Console.printHeader(this.title + " ***");
		
		Iterator<T> iterator = this.data.iterator();
		
		while(iterator.hasNext()) {
			Console.print(iterator.next());
		}
	}
	
}
