package views;

import core.View;
import services.Console;

public class ErrorView extends View {
	
	private String message;
	
	public ErrorView(String message) {
		this.message = message;
	}
	
	@Override
	public void render(){
		Console.print(this.message);
		Console.endl();
	}
}
