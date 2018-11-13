package controller;

import junit.framework.TestCase;
import model.PuzzleModel;
import puzzle.Puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovePieceTest extends TestCase {
	
	public void testMovePieceDown() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		MovePieceController controller = new MovePieceController(app, m);
		m.selected_piece = "panel_7";
		controller.move('s');
		
		assertEquals(m.selected_piece, "none");
		assertEquals(app.pieces[7].getY(), 405);
	}
	
	public void testMovePieceLeft() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		MovePieceController controller = new MovePieceController(app, m);
		m.selected_piece = "panel_9";
		controller.move('a');
		
		assertEquals(m.selected_piece, "none");
		assertEquals(app.pieces[9].getX(), 205);		
	}

	public void testMovePieceRight() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		MovePieceController controller = new MovePieceController(app, m);
		m.selected_piece = "panel_8";
		controller.move('d');
		
		assertEquals(m.selected_piece, "none");
		assertEquals(app.pieces[8].getX(), 105);		
	}
	
	public void testMovePieceUp() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});
		
		MovePieceController controller = new MovePieceController(app, m);

		m.selected_piece = "panel_6";
		controller.move('s');
		assertEquals(m.selected_piece, "none");
		assertEquals(app.pieces[6].getY(), 405);				
		
		m.selected_piece = "panel_6";
		controller.move('w');
		assertEquals(m.selected_piece, "none");
		assertEquals(app.pieces[6].getY(), 305);		
	}
}
