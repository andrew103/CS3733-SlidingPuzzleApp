package controller;

import javax.swing.JOptionPane;

import puzzle.Puzzle;
import model.PuzzleModel;

public class ClosePuzzleController {
	final Puzzle app;
	final PuzzleModel model;
	
	public ClosePuzzleController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
	
	public void close() {
		this.app.setVisible(false);
		this.app.dispose();
	}
}
