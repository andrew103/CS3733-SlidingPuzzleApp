package controller;

import junit.framework.TestCase;
import model.PuzzleModel;
import puzzle.Puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResetPuzzleTest extends TestCase {

	public void testAppReset() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});

		app.pieces[9].setLocation(205, 405);
		m.moveLeft(3, 4);
		
		ResetPuzzleController controller = new ResetPuzzleController(app, m);
		controller.reset();
		
		assertEquals(app.pieces[9].getX(), 305);
		assertEquals(m.getGrid()[4][3], "panel_9");
	}
}
