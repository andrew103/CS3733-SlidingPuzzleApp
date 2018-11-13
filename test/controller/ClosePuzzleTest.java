package controller;

import junit.framework.TestCase;
import model.PuzzleModel;
import puzzle.Puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosePuzzleTest extends TestCase {
	
	public void testCloseApp() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		ClosePuzzleController controller = new ClosePuzzleController(app, m);
		controller.close();
		
		assertFalse(app.isVisible());
	}
}
