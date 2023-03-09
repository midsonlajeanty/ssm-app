package views;

import core.View;
import services.Console;

public class SuccessView extends View {

	private String message;

	public SuccessView(String message) {
		this.message = message;
	}

	@Override
	public void render() {
		Console.printHeader("# SUCCESS ");
		Console.print(this.message);
		Console.endl();
	}

}
