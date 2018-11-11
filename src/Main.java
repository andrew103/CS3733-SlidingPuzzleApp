import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.InitializePuzzleController;
import model.PuzzleModel;
import puzzle.Puzzle;

public class Main {
	public static void main (String[] args) {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle();

		InitializePuzzleController.initialize(app, m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {}      
		});
		
		app.setVisible(true);
}
}
