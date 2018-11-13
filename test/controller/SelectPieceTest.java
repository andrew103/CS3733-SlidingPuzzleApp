package controller;

import junit.framework.TestCase;
import model.PuzzleModel;
import puzzle.Puzzle;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;

public class SelectPieceTest extends TestCase {

	public void testSelectPiece() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});

		SelectPieceController controller = new SelectPieceController(app, m);
		controller.selectPiece(250, 150);
		
		assertEquals(m.selected_piece, "target");
	}
	
	public void testDeselectAndSelectPiece() {
		PuzzleModel m = new PuzzleModel();
		Puzzle app = new Puzzle(m);
		
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.setVisible(false);
				app.dispose();
			}
		});

		SelectPieceController controller = new SelectPieceController(app, m);

		controller.selectPiece(250, 150);	
		assertEquals(m.selected_piece, "target");

		controller.selectPiece(250, 250);
		assertEquals(m.selected_piece, "panel_1");
	}
}
