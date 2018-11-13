package controller;

import puzzle.Puzzle;
import model.PuzzleModel;

public class RefocusController {
	final Puzzle app;
	final PuzzleModel model;
	
	public RefocusController(Puzzle app, PuzzleModel m) {
		this.app = app;
		this.model = m;
	}
	
	public void refocus() {
		this.app.contentPane.requestFocusInWindow();
	}
}
