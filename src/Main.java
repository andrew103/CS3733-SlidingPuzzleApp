import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import controller.PuzzleController;
import model.PuzzleModel;
import puzzle.Puzzle;

public class Main {
	public static void main (String[] args) {
		String[][] grid = new String[4][5];
		
		PuzzleModel m = new PuzzleModel(grid);
		Puzzle app = new Puzzle();

		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {}      
		});
		
		app.setVisible(true);
}
}
