import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.PuzzleModel;
import puzzle.Puzzle;

public class Main {
	public static void main (String[] args) {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);

		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		app.setVisible(true);
		app.contentPane.requestFocusInWindow();
	}
}
